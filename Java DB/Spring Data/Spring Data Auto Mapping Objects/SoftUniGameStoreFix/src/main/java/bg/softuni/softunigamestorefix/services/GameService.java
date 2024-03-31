package bg.softuni.softunigamestorefix.services;

import bg.softuni.softunigamestorefix.entities.Game;
import bg.softuni.softunigamestorefix.services.dtos.AddGameDTO;

import java.util.List;

public interface GameService {
    String addGame(AddGameDTO addGameDTO);

    Game findGameById(Long gameId);

    void updateGame(Game gameToUpdate);

    void deleteById(Long id);

    List<Game> getAllGames();

    Game findGameByTitle(String title);
}
