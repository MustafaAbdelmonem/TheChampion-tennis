package com.digital.factory.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "matches")
@Data
public class Match  implements Serializable {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @ManyToOne
    @JoinColumn(name = "first_participant_id")
    private Participant firstParticipan;

    @ManyToOne
    @JoinColumn(name = "second_participant_id")
    private Participant secondParticipant;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    @Temporal(TemporalType.DATE)
    private Date date;
}
