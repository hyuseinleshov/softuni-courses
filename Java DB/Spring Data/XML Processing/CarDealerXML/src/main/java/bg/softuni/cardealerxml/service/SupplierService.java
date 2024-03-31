package bg.softuni.cardealerxml.service;

import jakarta.xml.bind.JAXBException;

public interface SupplierService {
    void seedSuppliers() throws JAXBException;

    void exportLocalSuppliers() throws JAXBException;
}
