package com.digital.factory.service;

import com.digital.factory.model.ParticipantDto;
import com.digital.factory.controllers.request.ParticipantRequest;

import java.util.List;

public interface ParticipantService {

    String submitParticipantRequest(ParticipantRequest participantRequest);
    List<ParticipantDto> listAllParticipants();
    List<List<ParticipantDto>> groupingParticipants(int numOfGroups);
}
