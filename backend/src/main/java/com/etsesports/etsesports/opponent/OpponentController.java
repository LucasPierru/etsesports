package com.etsesports.etsesports.opponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/opponents")
public class OpponentController {
    private final OpponentService opponentService;

    @Autowired
    public OpponentController (OpponentService opponentService) {
        this.opponentService = opponentService;
    }

    @GetMapping()
    public List<Opponent> getOpponent() {
        return opponentService.getOpponents();
    }

    @PostMapping()
    public void createOpponent(@RequestBody Opponent opponent) {
        opponentService.createOpponent(opponent);
    }

    @DeleteMapping(path = "{opponentId}")
    public void deleteCoach(@PathVariable("opponentId") Long opponentId) {
        opponentService.deleteOpponent(opponentId);
    }

    @PutMapping(path = "{opponentId}")
    public void updateCoach(@PathVariable("opponentId") Long opponentId, @RequestParam(required = false) String name, @RequestParam(required = false) Long schoolId) {
        opponentService.updateOpponent(opponentId, name, schoolId);
    }
}
