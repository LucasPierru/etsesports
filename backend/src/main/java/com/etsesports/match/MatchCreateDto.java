package com.etsesports.etsesports.match;

import java.time.LocalDateTime;

public record MatchCreateDto(Long team, Long opponent, Long game, LocalDateTime dateTime, int teamScore, int opponentScore) {
}