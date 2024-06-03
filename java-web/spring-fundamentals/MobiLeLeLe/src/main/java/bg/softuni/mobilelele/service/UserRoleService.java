package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole getById(Long id);
    List<UserRole> getAll();
    UserRole save(UserRole userRole);
    void delete(Long id);
}
