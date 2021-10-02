package com.digital.factory.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class League implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String leagueName;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Round> rounds;

    @OneToOne
    @JoinColumn(name = "champion_id")
    private Participant  championId;
}
