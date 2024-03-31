package bg.softuni.cardealerxml;

import bg.softuni.cardealerxml.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;

    public CommandLineRunnerImpl(CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
        this.customerService.seedCustomers();
        this.saleService.seedSales();

//        this.customerService.exportOrderedCustomers();
//        this.carService.exportToyotaCars();
//        this.supplierService.exportLocalSuppliers();
//        this.carService.exportCarsAndParts();
//        this.customerService.exportCustomersTotalSales();
        this.saleService.exportSalesDiscounts();
    }
}
