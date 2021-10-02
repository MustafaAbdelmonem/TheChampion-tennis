package com.digital.factory.controllers.request;

import lombok.Data;

import java.util.Date;

import com.digital.factory.entity.Player;

@Data
public class ParticipantRequest {
//    private String firstName;
//    private String lastName;
//    private String email;
	private Integer playerId;
    private Date registrationDate;
}
