package com.etsesports.match;

import com.etsesports.game.Game;
import com.etsesports.game.GameRepository;
import com.etsesports.opponent.Opponent;
import com.etsesports.opponent.OpponentRepository;
import com.etsesports.team.Team;
import com.etsesports.team.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final OpponentRepository opponentRepository;
    private final GameRepository gameRepository;
    private final MatchMapper matchMapper;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, OpponentRepository opponentRepository, GameRepository gameRepository, MatchMapper matchMapper) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.opponentRepository = opponentRepository;
        this.gameRepository = gameRepository;
        this.matchMapper = matchMapper;
    }

    public List<MatchDto> getMatches() {
        return matchRepository.findAll().stream().map(matchMapper::toDto).toList();
    }

    @Transactional
    public MatchDto createMatch(MatchCreateDto match) {
        Team team = teamRepository.findById(match.team())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        Opponent opponent = opponentRepository.findById(match.opponent())
                .orElseThrow(() -> new RuntimeException("Opponent not found"));
        Game game = gameRepository.findById(match.game())
                .orElseThrow(() -> new RuntimeException("Game not found"));

        Match newMatch = matchRepository.save(new Match(team, opponent, game, match.dateTime(), match.teamScore(), match.opponentScore()));

        return matchMapper.toDto(newMatch);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    @Transactional
    public void updateMatch(Long matchId, Long teamId, Long opponentId, Long gameId, LocalDateTime dateTime, int teamScore, int opponentScore) {
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
        match.setDateTime(dateTime);
        match.setTeamScore(teamScore);
        match.setOpponentScore(opponentScore);
    }
}
