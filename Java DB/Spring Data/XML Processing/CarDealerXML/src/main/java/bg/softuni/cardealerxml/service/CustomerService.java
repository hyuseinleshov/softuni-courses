package bg.softuni.cardealerxml.service;

import bg.softuni.cardealerxml.data.entities.Customer;
import jakarta.xml.bind.JAXBException;

import java.util.List;

public interface CustomerService {
    void seedCustomers() throws JAXBException;

    void exportOrderedCustomers() throws JAXBException;

    void exportCustomersTotalSales() throws JAXBException;
}
