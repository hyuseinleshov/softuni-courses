package bg.softuni.softunigamestorefix.services.impl;

import bg.softuni.softunigamestorefix.entities.Game;
import bg.softuni.softunigamestorefix.repositories.GameRepository;
import bg.softuni.softunigamestorefix.services.GameService;
import bg.softuni.softunigamestorefix.services.dtos.AddGameDTO;
import bg.softuni.softunigamestorefix.services.util.ValidationService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ValidationService validationService;
    private final ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository, ValidationService validationService, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.validationService = validationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addGame(AddGameDTO addGameDTO) {
        if (!this.validationService.isValid(addGameDTO)) {
            return this.validationService.validate(addGameDTO)
                    .stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        Game game = this.modelMapper.map(addGameDTO, Game.class);
        this.gameRepository.saveAndFlush(game);

        return String.format("Added %s", game.getTitle());
    }

    @Override
    public Game findGameById(Long gameId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        return gameOptional.orElse(null);
    }

    @Override
    public void updateGame(Game gameToUpdate) {
        this.gameRepository.saveAndFlush(gameToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game findGameByTitle(String title) {
        return this.gameRepository.findGameByTitle(title);
    }
}
