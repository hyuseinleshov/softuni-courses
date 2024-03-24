package bg.softuni.softunigamestorefix.repositories;


import bg.softuni.softunigamestorefix.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    void deleteById(Long id);

    Game findGameByTitle(String title);
}
