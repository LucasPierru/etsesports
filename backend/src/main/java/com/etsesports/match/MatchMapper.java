package com.etsesports.etsesports.match;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    @Mapping(source = "team.name", target = "team")
    @Mapping(source = "opponent.name", target = "opponent")
    @Mapping(source = "game.name", target = "game")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    MatchDto toDto(Match match);
}
