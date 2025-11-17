package com.etsesports.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/coaches")
public class CoachController {
    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public List<Coach> getCoaches() {
        return coachService.getCoaches();
    }

    @PostMapping
    public void createCoach(@RequestBody Coach coach) {
        coachService.createCoach(coach);
    }

    @DeleteMapping(path = "{coachId}")
    public void deleteCoach(@PathVariable("coachId") Long coachId) {
        coachService.deleteCoach(coachId);
    }

    @PutMapping(path = "{coachId}")
    public void updateCoach(@PathVariable("coachId") Long coachId, @RequestParam(required = false) Long teamId) {
        coachService.updateCoach(coachId, teamId);
    }
}
