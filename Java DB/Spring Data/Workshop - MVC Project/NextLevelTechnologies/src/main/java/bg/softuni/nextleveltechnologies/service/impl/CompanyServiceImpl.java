package bg.softuni.nextleveltechnologies.service.impl;

import bg.softuni.nextleveltechnologies.dto.imports.CompanyImportDTO;
import bg.softuni.nextleveltechnologies.dto.imports.CompanyImportRootDTO;
import bg.softuni.nextleveltechnologies.model.Company;
import bg.softuni.nextleveltechnologies.repository.CompanyRepository;
import bg.softuni.nextleveltechnologies.service.CompanyService;
import bg.softuni.nextleveltechnologies.util.xml.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final String FILE_IMPORT_COMPANIES_PATH = "src/main/resources/files/xmls/companies.xml";
    private final CompanyRepository companyRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCompanies() {
        if (companyRepository.count() == 0) {
            try {
                CompanyImportRootDTO companies = xmlParser.parse(CompanyImportRootDTO.class, FILE_IMPORT_COMPANIES_PATH);

                for (CompanyImportDTO company : companies.getCompanies()) {
                    Company map = modelMapper.map(company, Company.class);
                    companyRepository.save(map);
                }
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
