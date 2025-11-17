package com.etsesports.etsesports.coach;

import com.etsesports.etsesports.team.Team;
import com.etsesports.etsesports.team.TeamRepository;
import com.etsesports.etsesports.user.User;
import com.etsesports.etsesports.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class CoachConfig {
    @Bean("coachDataLoader")
    @DependsOn("teamDataLoader")
    @Order(5)
    CommandLineRunner commandLineRunner (TeamRepository teamRepository, CoachRepository coachRepository, UserRepository userRepository) {
        return args -> {
            Team valorant = teamRepository.getReferenceById(1L);
            User lucas = userRepository.getReferenceById(1L);
            Coach coach = new Coach(lucas, valorant);
            coachRepository.saveAll(List.of(coach));
        };
    }
}
