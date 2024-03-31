package bg.softuni.cardealerxml.service.impls;

import bg.softuni.cardealerxml.data.entities.Part;
import bg.softuni.cardealerxml.data.entities.Supplier;
import bg.softuni.cardealerxml.data.repositories.PartRepository;
import bg.softuni.cardealerxml.data.repositories.SupplierRepository;
import bg.softuni.cardealerxml.service.PartService;
import bg.softuni.cardealerxml.service.dtos.imports.PartSeedDto;
import bg.softuni.cardealerxml.service.dtos.imports.PartSeedRootDto;
import bg.softuni.cardealerxml.util.validations.ValidationUtil;
import bg.softuni.cardealerxml.util.xmlprocessing.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private static final String FILE_SEED_PATH = "src/main/resources/xml/imports/parts.xml";
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, Random random) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedParts() throws JAXBException {
        if (this.partRepository.count() == 0) {
            List<Supplier> suppliers = this.supplierRepository.findAll();
            PartSeedRootDto partSeedRootDto  = this.xmlParser.parse(PartSeedRootDto.class, FILE_SEED_PATH);

            for (PartSeedDto part : partSeedRootDto.getParts()) {
                if (!this.validationUtil.isValid(part)) {
                    System.out.println("Invalid part!");

                    continue;
                }

                Part map = this.modelMapper.map(part, Part.class);
                map.setSupplier(getRandomSupplier(suppliers));
                this.partRepository.saveAndFlush(map);
            }

            System.out.println();
        }
    }

    private Supplier getRandomSupplier(List<Supplier> suppliers) {
        return suppliers.get(random.nextInt(suppliers.size()));
    }
}
