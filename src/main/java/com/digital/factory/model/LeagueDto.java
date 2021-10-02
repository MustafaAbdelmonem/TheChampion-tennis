package com.digital.factory.model;

import lombok.Data;

import java.util.Date;

@Data
public class LeagueDto {

    private Integer id;
    private String leagueName;
    private String location;
    private Integer numberOfRounds;
}
