package bg.softuni.productshop.service.impl;

import bg.softuni.productshop.data.entities.Product;
import bg.softuni.productshop.data.entities.User;
import bg.softuni.productshop.data.repository.ProductRepository;
import bg.softuni.productshop.data.repository.UserRepository;
import bg.softuni.productshop.service.ProductService;
import bg.softuni.productshop.service.dtos.exports.ProductInRangeDto;
import bg.softuni.productshop.service.dtos.imports.ProductSeedDto;
import bg.softuni.productshop.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    public static final String FILE_PATH = "src/main/resources/json/products.json";
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final Random random;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, Random random) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.random = random;
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        if (productRepository.count() == 0) {
            Reader reader = new FileReader(FILE_PATH);
            ProductSeedDto[] productSeedDtos = gson.fromJson(reader, ProductSeedDto[].class);

            List<User> users = userRepository.findAll();

            Arrays.stream(productSeedDtos)
                    .filter(validationUtil::isValid)
                    .forEach(productSeedDto -> {
                        User buyer = getRandomUser(users);
                        User seller = getRandomUser(users);
                        if (buyer != null && seller != null) {
                            Product product = modelMapper.map(productSeedDto, Product.class);
                            if (buyer.equals(seller)) {
                                product.setBuyer(null);
                                product.setSeller(seller);
                            } else if (productRepository.count() % 10 == 0) {
                                product.setBuyer(null);
                                product.setSeller(seller);
                            } else {
                                product.setBuyer(buyer);
                                product.setSeller(seller);
                            }
                            productRepository.saveAndFlush(product);
                        }
                    });

            System.out.println("Products seeded successfully.");
        }
    }

    @Override
    public List<ProductInRangeDto> getAllProductsInRange(BigDecimal from, BigDecimal to) {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(from, to)
                .stream()
                .map(p ->{
                    ProductInRangeDto dto = this.modelMapper.map(p, ProductInRangeDto.class);
                    dto.setSeller(p.getSeller().getFirstName() + " " + p.getSeller().getLastName());
                    return dto;
                })
                .sorted(Comparator.comparing(ProductInRangeDto::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public void printAllProductsInRange(BigDecimal from, BigDecimal to) {
        System.out.println(this.gson.toJson(this.getAllProductsInRange(from, to)));
    }

    private User getRandomUser(List<User> users) {
        if (users.isEmpty()) {
            return null;
        }
        return users.get(random.nextInt(users.size()));
    }
}
