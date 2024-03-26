package bg.softuni.productshop;

import bg.softuni.productshop.service.CategoryService;
import bg.softuni.productshop.service.ProductService;
import bg.softuni.productshop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;

    public CommandLineRunnerImpl(CategoryService categoryService, ProductService productService, UserService userService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.seedUsers();
        this.productService.seedProducts();
        this.categoryService.seedCategoriesForProducts();

//        this.productService.printAllProductsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
//        this.userService.printAllUsersAndSoldItems();
        this.categoryService.printAllCategoriesByProducts();
    }
}
