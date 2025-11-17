package com.etsesports.etsesports.team;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    final TeamRepository teamRepository;

    @Autowired
    public TeamService (TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    @Transactional
    public void updateTeam (Long teamId, String name) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalStateException("Team with id " + teamId + " does not exist"));
        team.setName(name);
    }
}
