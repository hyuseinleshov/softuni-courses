package bg.softuni.productshop.service.impl;

import bg.softuni.productshop.data.entities.Category;
import bg.softuni.productshop.data.entities.Product;
import bg.softuni.productshop.data.repository.CategoryRepository;
import bg.softuni.productshop.data.repository.ProductRepository;
import bg.softuni.productshop.service.CategoryService;
import bg.softuni.productshop.service.dtos.exports.CategoriesByProductsDto;
import bg.softuni.productshop.service.dtos.imports.CategorySeedDto;
import bg.softuni.productshop.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public static final String FILE_PATH = "src/main/resources/json/categories.json";
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final Random random;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, Random random) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.random = random;
    }

    @Override
    public void seedCategoriesForProducts() throws FileNotFoundException {
        if (categoryRepository.count() == 0) {
            seedCategories();

            List<Category> categories = this.categoryRepository.findAll();
            if (!categories.isEmpty()) {
                productRepository.findAll().forEach(product -> {
                    List<Category> shuffledCategories = new ArrayList<>(categories);
                    Collections.shuffle(shuffledCategories);
                    int numberOfCategories = random.nextInt(5);
                    List<Category> selectedCategories = new ArrayList<>();
                    for (int i = 0; i < numberOfCategories; i++) {
                        selectedCategories.add(shuffledCategories.get(i));
                    }
                    product.setCategories(selectedCategories);
                    productRepository.save(product);
                });
                System.out.println("Categories seeded for products successfully.");
            }
        }
    }

    @Override
    public List<CategoriesByProductsDto> getAllCategoriesByProducts() {
        List<Category> sortedCategories = new ArrayList<>(this.categoryRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(c -> c.getProducts().size()))
                .toList());
        Collections.reverse(sortedCategories);

        List<CategoriesByProductsDto> categoriesByProducts = sortedCategories.stream()
                .map(c -> {
                    List<Product> products = c.getProducts();
                    CategoriesByProductsDto categoriesDto = this.modelMapper.map(c, CategoriesByProductsDto.class);

                    categoriesDto.setCategory(c.getName());
                    categoriesDto.setProductsCount(products.size());

                    BigDecimal averagePrice = products.stream()
                            .map(Product::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add)
                            .divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP);
                    categoriesDto.setAveragePrice(averagePrice);

                    BigDecimal totalRevenue = products.stream()
                            .map(Product::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    categoriesDto.setTotalRevenue(totalRevenue);

                    return categoriesDto;
                })
                .toList();
        return categoriesByProducts;
    }

    @Override
    public void printAllCategoriesByProducts() {
        String json = this.gson.toJson(this.getAllCategoriesByProducts());
        System.out.println(json);
    }

    private void seedCategories() throws FileNotFoundException {
        if (categoryRepository.count() == 0) {
            Reader reader = new FileReader(FILE_PATH);
            CategorySeedDto[] categories = gson.fromJson(reader, CategorySeedDto[].class);

            for (CategorySeedDto category : categories) {
                if (!this.validationUtil.isValid(categories)) {
                    this.validationUtil.getViolations(category)
                            .forEach(v -> System.out.println(v.getMessage()));

                    continue;
                }

                this.categoryRepository.saveAndFlush(modelMapper.map(category, Category.class));
            }
        }
    }
}
