package com.digital.factory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Participants")
@Data
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

}
