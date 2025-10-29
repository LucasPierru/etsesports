package com.etsesports.etsesports.coach;

import com.etsesports.etsesports.team.Team;
import com.etsesports.etsesports.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @SequenceGenerator(
            name = "coaches_sequence",
            sequenceName = "coaches_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coaches_sequence"
    )
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Coach() {

    }

    public Coach(Long id, User user, Team team){
        this.id = id;
        this.user = user;
        this.team = team;
    }

    public Coach(User user, Team team){
        this.user = user;
        this.team = team;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

}
