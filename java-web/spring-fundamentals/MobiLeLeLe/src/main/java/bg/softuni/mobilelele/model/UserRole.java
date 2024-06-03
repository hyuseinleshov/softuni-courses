package bg.softuni.mobilelele.model;

import bg.softuni.mobilelele.model.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Role name;

    public UserRole() {}

    public UserRole(Role name) {
        this.name = name;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role role) {
        this.name = role;
    }
}
