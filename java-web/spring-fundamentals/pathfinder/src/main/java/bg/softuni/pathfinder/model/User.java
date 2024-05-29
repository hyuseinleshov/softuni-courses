package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    private int age;

    private String email;

    // TODO Each registered user should have a "User" role
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    @Column(columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    private Level level;

    public User() {
        this.roles = new HashSet<>();
    }
}
