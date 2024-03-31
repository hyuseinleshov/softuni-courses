package bg.softuni.cardealerxml.service.impls;

import bg.softuni.cardealerxml.data.entities.Car;
import bg.softuni.cardealerxml.data.entities.Customer;
import bg.softuni.cardealerxml.data.entities.Part;
import bg.softuni.cardealerxml.data.entities.Sale;
import bg.softuni.cardealerxml.data.repositories.CarRepository;
import bg.softuni.cardealerxml.data.repositories.CustomerRepository;
import bg.softuni.cardealerxml.data.repositories.SaleRepository;
import bg.softuni.cardealerxml.service.SaleService;
import bg.softuni.cardealerxml.service.dtos.exports.CarDto;
import bg.softuni.cardealerxml.service.dtos.exports.SalesDiscountsDto;
import bg.softuni.cardealerxml.service.dtos.exports.SalesDiscountsRootDto;
import bg.softuni.cardealerxml.util.xmlprocessing.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private static final List<Double> discounts = List.of(0.0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4, 0.5);
    private static final String FILE_EXPORT_SALES_DISCOUNTS_PATH = "src/main/resources/xml/exports/sales-discounts.xml";
    private SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final Random random;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, Random random, ModelMapper modelMapper, XmlParser xmlParser) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.random = random;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSales() {
        if (this.saleRepository.count() == 0) {
            List<Car> cars = this.carRepository.findAll();
            List<Customer> customers = this.customerRepository.findAll();

            for (int i = 0; i < 100; i++) {
                Sale sale = new Sale();
                sale.setCar(getRandomCar(cars));
                Customer customer = getRandomCustomer(customers);
                sale.setCustomer(customer);
                double discount = discounts.get(random.nextInt(discounts.size()));
                if (customer.isYoungDriver()) {
                    discount += 0.05;
                }
                sale.setDiscount(discount);

                try {
                    this.saleRepository.saveAndFlush(sale);
                } catch (DataIntegrityViolationException e) {
                    System.out.println("Duplicate entry found, skipping...");
                }
            }
        }
    }

    @Override
    public void exportSalesDiscounts() throws JAXBException {
        List<SalesDiscountsDto> sales = this.saleRepository.findAll().stream()
                .map(s -> {
                    SalesDiscountsDto map = this.modelMapper.map(s, SalesDiscountsDto.class);
                    CarDto mappedCar = this.modelMapper.map(s.getCar(), CarDto.class);
                    map.setCar(mappedCar);

                    BigDecimal price = BigDecimal.ZERO;
                    for (Part part : s.getCar().getParts()) {
                        price = price.add(part.getPrice());
                    }
                    map.setPrice(price);

                    BigDecimal discount = price.multiply(BigDecimal.valueOf(s.getDiscount()));
                    price = price.subtract(discount);
                    map.setPriceWithDiscount(price);

                    return map;
                })
                .toList();

        SalesDiscountsRootDto salesDiscountsDto = new SalesDiscountsRootDto();
        salesDiscountsDto.setSales(sales);

        this.xmlParser.exportTo(salesDiscountsDto, FILE_EXPORT_SALES_DISCOUNTS_PATH);
    }

    private Customer getRandomCustomer(List<Customer> customers) {
        return customers.get(random.nextInt(customers.size()));
    }

    private Car getRandomCar(List<Car> cars) {
        return cars.get(random.nextInt(cars.size()));
    }
}
