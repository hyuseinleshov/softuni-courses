package bg.softuni.cardealerxml.data.repositories;

import bg.softuni.cardealerxml.data.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findAllByIsImporterFalse();
}
