package com.etsesports.etsesports.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    public void updateTeam (Long playerId, String username) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new IllegalStateException("Player with id " + playerId + " does not exist"));
        player.setUsername(username);
    }
}
