package bg.softuni.cardealerxml.data.repositories;

import bg.softuni.cardealerxml.data.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
