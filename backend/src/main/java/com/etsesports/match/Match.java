package com.etsesports.match;

import com.etsesports.game.Game;
import com.etsesports.opponent.Opponent;
import com.etsesports.team.Team;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @SequenceGenerator(
            name = "matches_sequence",
            sequenceName = "matches_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "matches_sequence"
    )
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "opponent_id", nullable = false)
    private Opponent opponent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    private LocalDateTime dateTime;
    private int teamScore;
    private int opponentScore;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Match() {

    }

    public Match(Long id, Team team, Opponent opponent, Game game, LocalDateTime dateTime, int teamScore, int opponentScore) {
        this.id = id;
        this.team = team;
        this.opponent = opponent;
        this.game = game;
        this.dateTime = dateTime;
        this.teamScore = teamScore;
        this.opponentScore = opponentScore;
    }

    public Match(Team team, Opponent opponent, Game game, LocalDateTime dateTime, int teamScore, int opponentScore) {
        this.team = team;
        this.opponent = opponent;
        this.game = game;
        this.dateTime = dateTime;
        this.teamScore = teamScore;
        this.opponentScore = opponentScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = Instant.now();
        if (updatedAt == null) updatedAt = Instant.now();
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", team=" + team +
                ", opponent=" + opponent +
                ", game=" + game +
                ", dateTime=" + dateTime +
                ", teamScore=" + teamScore +
                ", opponentScore=" + opponentScore +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
