package bg.softuni.cardealerxml.data.repositories;

import bg.softuni.cardealerxml.data.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
