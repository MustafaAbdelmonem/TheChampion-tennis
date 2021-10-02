package com.digital.factory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Round implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToMany(mappedBy = "round", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Match> matches;

    private boolean isOpen = false;

}
