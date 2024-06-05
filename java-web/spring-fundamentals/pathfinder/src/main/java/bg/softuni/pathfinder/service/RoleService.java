package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.enums.UserRole;

import java.util.Optional;

public interface RoleService {

    Role findByName(UserRole userRole);
}
