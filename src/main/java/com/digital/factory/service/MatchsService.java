package com.digital.factory.service;

import com.digital.factory.model.MatchDto;
import com.digital.factory.controllers.request.MatchResultRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MatchsService {

    List<MatchDto> listMatchesByRound(Integer round);
    String updateMatch(MatchResultRequest matchResultRequest);
    String closeRound(Integer round);

}
