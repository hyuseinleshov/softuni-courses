package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getById(Long id);
    List<UserEntity> getAll();
    UserEntity save(UserEntity user);
    void delete(Long id);
}
