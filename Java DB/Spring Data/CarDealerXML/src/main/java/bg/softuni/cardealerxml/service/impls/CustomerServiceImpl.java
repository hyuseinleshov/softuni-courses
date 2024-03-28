package bg.softuni.cardealerxml.service.impls;

import bg.softuni.cardealerxml.data.entities.Customer;
import bg.softuni.cardealerxml.data.entities.Part;
import bg.softuni.cardealerxml.data.entities.Sale;
import bg.softuni.cardealerxml.data.repositories.CustomerRepository;
import bg.softuni.cardealerxml.service.CustomerService;
import bg.softuni.cardealerxml.service.dtos.exports.CustomerOrderDto;
import bg.softuni.cardealerxml.service.dtos.exports.CustomerOrderRootDto;
import bg.softuni.cardealerxml.service.dtos.exports.CustomerSalesDto;
import bg.softuni.cardealerxml.service.dtos.exports.CustomerSalesRootDto;
import bg.softuni.cardealerxml.service.dtos.imports.CustomerSeedDto;
import bg.softuni.cardealerxml.service.dtos.imports.CustomerSeedRootDto;
import bg.softuni.cardealerxml.util.xmlprocessing.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private static final String FILE_SEED_PATH = "src/main/resources/xml/imports/customers.xml";
    private static final String FILE_EXPORT_CUSTOMERS_SALES_PATH = "src/main/resources/xml/exports/customers-total-sales.xml";
    private static final String FILE_EXPORT_CUSTOMERS_PATH = "src/main/resources/xml/exports/ordered-customers.xml";
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers() throws JAXBException {
        if (this.customerRepository.count() == 0) {
            CustomerSeedRootDto customers = this.xmlParser.parse(CustomerSeedRootDto.class, FILE_SEED_PATH);

            for (CustomerSeedDto customer : customers.getCustomers()) {
                Customer map = this.modelMapper.map(customer, Customer.class);
                this.customerRepository.saveAndFlush(map);
            }
        }
    }

    @Override
    public void exportOrderedCustomers() throws JAXBException {
        List<CustomerOrderDto> customerDtos = this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriverAsc().stream()
                .map(c -> this.modelMapper.map(c, CustomerOrderDto.class))
                .toList();

        CustomerOrderRootDto orderRootDto = new CustomerOrderRootDto();
        orderRootDto.setCustomers(customerDtos);

        this.xmlParser.exportTo(orderRootDto, FILE_EXPORT_CUSTOMERS_PATH);

        System.out.println();
    }

    @Override
    public void exportCustomersTotalSales() throws JAXBException {
        List<CustomerSalesDto> customers = this.customerRepository.findAllBySalesIsNotEmpty().stream()
                .map(c -> {
                    CustomerSalesDto map = this.modelMapper.map(c, CustomerSalesDto.class);
                    map.setFullName(c.getName());
                    map.setBoughtCars(c.getSales().size());

                    BigDecimal spentMoney = BigDecimal.ZERO;
                    List<Sale> sales = c.getSales();
                    for (Sale sale : sales) {
                        for (Part part : sale.getCar().getParts()) {
                            BigDecimal price = part.getPrice();
                            spentMoney = spentMoney.add(price); // Assign the result back to spentMoney
                        }
                    }
                    map.setSpentMoney(spentMoney);
                    return map;
                })
                .toList();

        CustomerSalesRootDto customerSalesDto = new CustomerSalesRootDto();
        customerSalesDto.setCustomers(customers);

        this.xmlParser.exportTo(customerSalesDto, FILE_EXPORT_CUSTOMERS_SALES_PATH);
    }
}
