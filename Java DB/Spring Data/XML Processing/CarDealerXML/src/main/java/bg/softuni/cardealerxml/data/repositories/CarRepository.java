package bg.softuni.cardealerxml.data.repositories;

import bg.softuni.cardealerxml.data.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByMakeOrderByTravelledDistanceDesc(String make);
}
