package bg.softuni.productshop.service;

import bg.softuni.productshop.service.dtos.exports.UserSoldProductsDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {
    void seedUsers() throws FileNotFoundException;

    List<UserSoldProductsDto> getAllUsersWithSoldProducts();

    void printAllUsersAndSoldItems();
}
