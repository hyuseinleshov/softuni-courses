package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.UserRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRole name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
