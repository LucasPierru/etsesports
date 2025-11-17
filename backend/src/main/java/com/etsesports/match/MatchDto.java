package com.etsesports.match;

import java.time.Instant;
import java.time.LocalDateTime;

public record MatchDto(Long id, String team, String opponent, String game, LocalDateTime dateTime, int teamScore, int opponentScore, Instant createdAt, Instant updatedAt) {
}


