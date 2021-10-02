package com.digital.factory.model;

import com.digital.factory.entity.League;
import com.digital.factory.entity.Participant;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Data
public class MatchDto  {

    private Integer id;
    private League leagueId;
    private ParticipantDto firstParticipantId;
    private ParticipantDto secondParticipantId;
    private Integer round;

}
