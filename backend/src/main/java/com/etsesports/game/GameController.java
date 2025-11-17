package com.etsesports.etsesports.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @PostMapping
    public void createGame(@RequestBody Game game) {
        gameService.createGame(game);
    }

    @DeleteMapping(path = "{gameId}")
    public void deleteGame(@PathVariable("gameId") Long gameId){
        gameService.deleteGame(gameId);
    }

    @PutMapping(path = "{gameId}")
    public void updateGame(@PathVariable("gameId") Long gameId, @RequestParam(required = false) String name){
        gameService.updateGame(gameId, name);
    }
}
