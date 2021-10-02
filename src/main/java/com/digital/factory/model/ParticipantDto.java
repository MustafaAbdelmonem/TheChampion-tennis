package com.digital.factory.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class ParticipantDto {
    private Integer id;
    private PlayerDto player;
    private Date registrationDate;

}
