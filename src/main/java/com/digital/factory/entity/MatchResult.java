package com.digital.factory.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
public class MatchResult  implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;


    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "winner_participant_id")
    private Participant winnerParticipant;



    @ManyToOne
    @JoinColumn(name = "loser_participant_id")
    private Participant loserParticipant;


}
