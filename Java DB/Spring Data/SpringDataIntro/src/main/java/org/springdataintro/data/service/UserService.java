package org.springdataintro.data.service;

import org.springdataintro.data.entities.User;

public interface UserService {

    void register(User user);

    User findUserById(int id);

    User findByName(String name);
}
