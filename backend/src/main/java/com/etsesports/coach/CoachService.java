package com.etsesports.coach;

import com.etsesports.team.Team;
import com.etsesports.team.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    private final CoachRepository coachRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository, TeamRepository teamRepository) {
        this.coachRepository = coachRepository;
        this.teamRepository = teamRepository;
    }

    public List<Coach> getCoaches() {
        return coachRepository.findAll();
    }

    public void createCoach(Coach coach) {
        coachRepository.save(coach);
    }

    public void deleteCoach(Long coachId) {
        coachRepository.deleteById(coachId);
    }

    @Transactional
    public void updateCoach (Long coachId, Long teamId) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(() -> new IllegalStateException("Coach with id " + coachId + " does not exist"));
        if (teamId != null) {
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new IllegalStateException("Team with id " + teamId + " not found"));
            coach.setTeam(team);
        }
    }
}
