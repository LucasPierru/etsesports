package com.etsesports.opponent;

import com.etsesports.school.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpponentRepository extends JpaRepository<Opponent, Long> {
    Optional<Opponent> findByNameAndSchool(String name, School school);
    @Query("select o from Opponent o join o.school s where o.name = :opponentName and s.name = :schoolName")
    Optional<Opponent> findByNameAndSchoolName(@Param("opponentName") String opponentName, @Param("schoolName") String schoolName);
}
