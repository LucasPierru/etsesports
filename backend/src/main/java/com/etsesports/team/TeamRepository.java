package com.etsesports.team;

import com.etsesports.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByNameAndGame(String name, Game game);

    @Query("select t from Team t join t.game g where t.name = :teamName and g.name = :gameName")
    Optional<Team> findByNameAndGameName(@Param("teamName") String teamName, @Param("gameName") String gameName);
}
