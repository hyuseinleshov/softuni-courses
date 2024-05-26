package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.models.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    List<User> getAll();
    User save(User user);
    void delete(Long id);
}
