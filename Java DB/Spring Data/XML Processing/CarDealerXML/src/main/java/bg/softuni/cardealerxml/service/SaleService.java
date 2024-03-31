package bg.softuni.cardealerxml.service;

import jakarta.xml.bind.JAXBException;

public interface SaleService {
    void seedSales();

    void exportSalesDiscounts() throws JAXBException;
}
