package bg.softuni.productshop.service.impl;

import bg.softuni.productshop.data.entities.User;
import bg.softuni.productshop.data.repository.UserRepository;
import bg.softuni.productshop.service.UserService;
import bg.softuni.productshop.service.dtos.exports.ProductSoldDto;
import bg.softuni.productshop.service.dtos.exports.UserSoldProductsDto;
import bg.softuni.productshop.service.dtos.imports.UserSeedDto;
import bg.softuni.productshop.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    public static final String FILE_PATH = "src/main/resources/json/users.json";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        if (this.userRepository.count() == 0) {
            Reader reader = new FileReader(FILE_PATH);
            UserSeedDto[] users = gson.fromJson(reader, UserSeedDto[].class);

            for (UserSeedDto user : users) {
                if (!this.validationUtil.isValid(user)) {
                    this.validationUtil.getViolations(user)
                            .forEach(v -> System.out.println(v.getMessage()));

                    continue;
                }

                this.userRepository.saveAndFlush(modelMapper.map(user, User.class));
            }
        }
    }

    @Override
    public List<UserSoldProductsDto> getAllUsersWithSoldProducts() {
        List<UserSoldProductsDto> allUsers = this.userRepository.findAll()
                .stream()
                .filter(u ->
                        u.getSoldProducts().stream().anyMatch(p -> p.getBuyer() != null))
                .map(u -> {
                    UserSoldProductsDto userDto = this.modelMapper.map(u, UserSoldProductsDto.class);
                    List<ProductSoldDto> soldProductsDto = u.getSoldProducts()
                            .stream()
                            .filter(p -> p.getBuyer() != null)
                            .map(p -> this.modelMapper.map(p, ProductSoldDto.class))
                            .collect(Collectors.toList());
                    userDto.setSoldProducts(soldProductsDto);
                    return userDto;
                })
                .sorted(Comparator.comparing(UserSoldProductsDto::getLastName).thenComparing(UserSoldProductsDto::getFirstName))
                .toList();

        return allUsers;
    }

    @Override
    public void printAllUsersAndSoldItems() {
        String json = this.gson.toJson(this.getAllUsersWithSoldProducts());
        System.out.println(json);
    }
}
