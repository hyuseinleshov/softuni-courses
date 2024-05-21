package bg.softuni.mobilelele.model;

import bg.softuni.mobilelele.model.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    private Role name;

    public Role getName() {
        return name;
    }

    public void setName(Role role) {
        this.name = role;
    }
}
