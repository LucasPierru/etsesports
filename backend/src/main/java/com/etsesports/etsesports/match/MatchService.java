package com.etsesports.etsesports.match;

import com.etsesports.etsesports.game.Game;
import com.etsesports.etsesports.game.GameRepository;
import com.etsesports.etsesports.opponent.Opponent;
import com.etsesports.etsesports.opponent.OpponentRepository;
import com.etsesports.etsesports.team.Team;
import com.etsesports.etsesports.team.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final OpponentRepository opponentRepository;
    private final GameRepository gameRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, OpponentRepository opponentRepository, GameRepository gameRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.opponentRepository = opponentRepository;
        this.gameRepository = gameRepository;
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public void createMatch(Match match) {
        matchRepository.save(match);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    @Transactional
    public void updateMatch(Long matchId, Long teamId, Long opponentId, Long gameId, Date date, int teamScore, int opponentScore) {
        Match match = matchRepository.findById(matchId).orElseThrow(() -> new IllegalStateException("Match with id " + matchId + " does not exist"));
        if (teamId != null) {
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new IllegalStateException("Team with id " + teamId + " not found"));
            match.setTeam(team);
        }
        if (opponentId != null) {
            Opponent opponent = opponentRepository.findById(opponentId)
                    .orElseThrow(() -> new IllegalStateException("Opponent with id " + opponentId + " not found"));
            match.setOpponent(opponent);
        }
        if (gameId != null) {
            Game game = gameRepository.findById(gameId)
                    .orElseThrow(() -> new IllegalStateException("Game with id " + gameId + " not found"));
            match.setGame(game);
        }
        match.setDate(date);
        match.setTeamScore(teamScore);
        match.setOpponentScore(opponentScore);
    }
}
