package bg.softuni.cardealerxml.service.impls;

import bg.softuni.cardealerxml.data.entities.Car;
import bg.softuni.cardealerxml.data.entities.Part;
import bg.softuni.cardealerxml.data.repositories.CarRepository;
import bg.softuni.cardealerxml.data.repositories.PartRepository;
import bg.softuni.cardealerxml.service.CarService;
import bg.softuni.cardealerxml.service.dtos.exports.CarsPartsDto;
import bg.softuni.cardealerxml.service.dtos.exports.CarsPartsRootDto;
import bg.softuni.cardealerxml.service.dtos.exports.ToyotaCarDto;
import bg.softuni.cardealerxml.service.dtos.exports.ToyotaCarRootDto;
import bg.softuni.cardealerxml.service.dtos.imports.CarSeedDto;
import bg.softuni.cardealerxml.service.dtos.imports.CarSeedRootDto;
import bg.softuni.cardealerxml.util.validations.ValidationUtil;
import bg.softuni.cardealerxml.util.xmlprocessing.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private static final String FILE_SEED_PATH = "src/main/resources/xml/imports/cars.xml";
    private static final String FILE_EXPORT_TOYOTA_PATH = "src/main/resources/xml/exports/toyota-cars.xml";
    private static final String FILE_EXPORT_CARS_PARTS_PATH = "src/main/resources/xml/exports/cars-and-parts.xml";
    private final PartRepository partRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, Random random) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedCars() throws JAXBException {
        if (this.carRepository.count() == 0) {
            List<Part> parts = this.partRepository.findAll();
            CarSeedRootDto cars = this.xmlParser.parse(CarSeedRootDto.class, FILE_SEED_PATH);

            for (CarSeedDto car : cars.getCars()) {
                if (!this.validationUtil.isValid(car)) {
                    System.out.println("Invalid car!");

                    continue;
                }

                Car map = this.modelMapper.map(car, Car.class);
                map.setParts(getRandomParts(parts));
                this.carRepository.saveAndFlush(map);
            }
            System.out.println();
        }
    }

    @Override
    public void exportToyotaCars() throws JAXBException {
        List<ToyotaCarDto> cars = this.carRepository.findAllByMakeOrderByTravelledDistanceDesc("Toyota").stream()
                .map(c -> this.modelMapper.map(c, ToyotaCarDto.class))
                .toList();

        ToyotaCarRootDto carRootDto = new ToyotaCarRootDto();
        carRootDto.setCars(cars);

        this.xmlParser.exportTo(carRootDto, FILE_EXPORT_TOYOTA_PATH);
    }

    @Override
    public void exportCarsAndParts() throws JAXBException {
        List<CarsPartsDto> cars = this.carRepository.findAll().stream()
                .map(c -> this.modelMapper.map(c, CarsPartsDto.class))
                .toList();

        CarsPartsRootDto carsPartsDto = new CarsPartsRootDto();
        carsPartsDto.setCars(cars);

        this.xmlParser.exportTo(carsPartsDto, FILE_EXPORT_CARS_PARTS_PATH);
    }

    private Set<Part> getRandomParts(List<Part> parts) {
        int countOfParts = this.random.nextInt(10, 20);
        Set<Part> randomParts = new HashSet<>();

        for (int i = 0; i < countOfParts + 1; i++) {
            Part part = parts.get(random.nextInt(parts.size()));
            randomParts.add(part);
        }

        return randomParts;
    }
}
