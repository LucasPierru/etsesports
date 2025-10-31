package com.etsesports.etsesports.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/matches")
public class MatchController {
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping()
    public List<Match> getMatches() {
        return List.of();
    }

    @PostMapping()
    public void createMatch(@RequestBody Match match) {

    }

    @DeleteMapping(path = "{matchId]")
    public void deleteMatch(@PathVariable("matchId") Long matchId) {

    }

    @PutMapping(path = "{matchId}")
    public void updateMatch(@PathVariable("matchId") Long matchId,
                            @RequestParam(required = false) Long opponentId,
                            @RequestParam(required = false) Long teamId,
                            @RequestParam(required = false) Long gameId,
                            @RequestParam(required = false) int teamScore,
                            @RequestParam(required = false) int opponentScore) {

    }
}
