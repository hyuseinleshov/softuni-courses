package bg.softuni.productshop.service;

import bg.softuni.productshop.service.dtos.exports.CategoriesByProductsDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryService {
    void seedCategoriesForProducts() throws FileNotFoundException;

    List<CategoriesByProductsDto> getAllCategoriesByProducts();

    void printAllCategoriesByProducts();
}
