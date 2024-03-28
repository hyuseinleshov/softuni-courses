package bg.softuni.cardealerxml.data.repositories;

import bg.softuni.cardealerxml.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByOrderByBirthDateAscIsYoungDriverAsc();

    List<Customer> findAllBySalesIsNotEmpty();
}
