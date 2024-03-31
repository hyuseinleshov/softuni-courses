package bg.softuni.cardealerxml.service.impls;

import bg.softuni.cardealerxml.data.entities.Supplier;
import bg.softuni.cardealerxml.data.repositories.SupplierRepository;
import bg.softuni.cardealerxml.service.SupplierService;
import bg.softuni.cardealerxml.service.dtos.exports.SupplierImporterDto;
import bg.softuni.cardealerxml.service.dtos.exports.SupplierImporterRootDto;
import bg.softuni.cardealerxml.service.dtos.imports.SupplierSeedDto;
import bg.softuni.cardealerxml.service.dtos.imports.SupplierSeedRootDto;
import bg.softuni.cardealerxml.util.validations.ValidationUtil;
import bg.softuni.cardealerxml.util.xmlprocessing.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private static final String FILE_LOCAL_SUPPLIER_PATH = "src/main/resources/xml/exports/local-suppliers.xml";
    private static final String FILE_SEED_PATH = "src/main/resources/xml/imports/suppliers.xml";
    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() throws JAXBException {
        if (this.supplierRepository.count() == 0) {
            SupplierSeedRootDto suppliers = xmlParser.parse(SupplierSeedRootDto.class, FILE_SEED_PATH);

            for (SupplierSeedDto supplier : suppliers.getSuppliers()) {
                if (!this.validationUtil.isValid(supplier)) {
                    System.out.println("Invalid supplier!");

                    continue;
                }

                this.supplierRepository.saveAndFlush(this.modelMapper.map(supplier, Supplier.class));
            }
        }
    }

    @Override
    public void exportLocalSuppliers() throws JAXBException {
        List<SupplierImporterDto> suppliers = this.supplierRepository.findAllByIsImporterFalse().stream()
                .map(s -> {
                    SupplierImporterDto map = this.modelMapper.map(s, SupplierImporterDto.class);
                    map.setPartsCount(s.getParts().size());
                    return map;
                })
                .toList();

        SupplierImporterRootDto supplierImporterDto = new SupplierImporterRootDto();
        supplierImporterDto.setSuppliers(suppliers);

        this.xmlParser.exportTo(supplierImporterDto, FILE_LOCAL_SUPPLIER_PATH);
    }
}
