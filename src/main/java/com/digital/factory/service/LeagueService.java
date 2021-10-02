package com.digital.factory.service;

import com.digital.factory.controllers.request.LeagueChampionRequest;
import com.digital.factory.model.MatchDto;
import com.digital.factory.controllers.request.MatchRequest;

public interface LeagueService {

    String submitLeagueChampion(LeagueChampionRequest leagueChampionRequest);
    String submitRequestMatch(MatchRequest matchRequest);
}
