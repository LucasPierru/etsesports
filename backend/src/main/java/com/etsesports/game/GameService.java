package com.etsesports.game;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return this.gameRepository.findAll();
    }

    public void createGame(Game game) {
        this.gameRepository.save(game);
    }

    public void deleteGame(Long gameId) {
        this.gameRepository.deleteById(gameId);
    }

    @Transactional
    public void updateGame(Long gameId, String name) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalStateException("Game with id " + gameId + " does not exist"));
        game.setName(name);
    }
}
