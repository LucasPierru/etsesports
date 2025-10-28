package com.etsesports.etsesports.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    public void createTeam(@RequestBody Team team) {
        teamService.createTeam(team);
    }

    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId){
        teamService.deleteTeam(teamId);
    }

    @PutMapping(path = "{teamId}")
    public void updateTeam(@PathVariable("teamId") Long teamId, @RequestParam(required = false) String name){
        teamService.updateTeam(teamId, name);
    }
}
