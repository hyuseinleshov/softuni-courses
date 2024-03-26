package bg.softuni.productshop.data.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected BaseEntity() {}

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
