package com.digital.factory.controllers.request;


import lombok.Data;


@Data
public class MatchResultRequest {

    private Integer matchId;
    private Integer winnerParticipantId;
    private Integer loserParticipantId;

}
