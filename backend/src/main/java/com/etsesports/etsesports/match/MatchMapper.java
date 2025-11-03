package com.etsesports.etsesports.match;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface MatchMapper {
    @Mapping(source = "team.name", target = "teamName")
    @Mapping(source = "opponent.name", target = "opponentName")
    @Mapping(source = "game.location", target = "location")
    MatchDto toDto(Match match);
}
