package bg.softuni.mobilelele.models;

import bg.softuni.mobilelele.models.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Role name;

    public Role getName() {
        return name;
    }

    public void setName(Role role) {
        this.name = role;
    }
}
