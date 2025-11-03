package com.etsesports.etsesports.opponent;

import com.etsesports.etsesports.school.School;
import com.etsesports.etsesports.school.SchoolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpponentService {
    private final OpponentRepository opponentRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public OpponentService (OpponentRepository opponentRepository, SchoolRepository schoolRepository) {
        this.opponentRepository = opponentRepository;
        this.schoolRepository = schoolRepository;
    }

    public List<Opponent> getOpponents() {
        return opponentRepository.findAll();
    }

    public void createOpponent(Opponent opponent) {
        opponentRepository.save(opponent);
    }

    public void deleteOpponent(Long opponentId) {
        opponentRepository.deleteById(opponentId);
    }

    @Transactional
    public void updateOpponent(Long opponentId, String name, Long schoolId) {
        Opponent opponent = opponentRepository.findById(opponentId).orElseThrow(() -> new IllegalStateException("Opponent with id " + opponentId + " does not exist"));
        if (schoolId != null) {
            School school = schoolRepository.findById(schoolId)
                    .orElseThrow(() -> new IllegalStateException("School with id " + schoolId + " not found"));
            opponent.setSchool(school);
        }
        opponent.setName(name);
    }
}
