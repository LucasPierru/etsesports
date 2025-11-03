package com.etsesports.etsesports.match;

import java.time.LocalDateTime;
import java.util.Date;

public record MatchDto(Long id, String team, String opponent, String game, LocalDateTime dateTime, int teamScore, int opponentScore, Date createdAt, Date updatedAt) {
}
