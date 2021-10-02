package com.digital.factory.controllers.request;

import java.util.Date;

import com.digital.factory.entity.Participant;

import lombok.Data;

@Data
public class MatchRequest {

    private Integer leagueId;

    private Integer roundId;

    private Integer firstParticipanId;

   private Integer secondParticipantId;
   
    private Date date;
}
