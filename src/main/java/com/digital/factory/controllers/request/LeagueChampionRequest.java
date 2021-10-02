package com.digital.factory.controllers.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LeagueChampionRequest {
    @NotNull(message = "The leagueId is required.")
    private Integer leagueId;

    @NotNull(message = "The championId is required.")
    private Integer championId;

}
