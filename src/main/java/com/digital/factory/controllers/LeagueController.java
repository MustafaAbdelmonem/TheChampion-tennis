package com.digital.factory.controllers;

import com.digital.factory.config.Constants;
import com.digital.factory.controllers.request.LeagueChampionRequest;
import com.digital.factory.controllers.request.MatchRequest;
import com.digital.factory.controllers.response.ApiResponse;
import com.digital.factory.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @PostMapping(value = Constants.SubmitRequestMatch_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> submitRequestMatch(@RequestBody MatchRequest submitMatchRequest) {

    	ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value())
				.statusMessage(Constants.SUCCESS_MESSAGE).data(leagueService.submitRequestMatch(submitMatchRequest)).build();

        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @PutMapping(value = Constants.SubmitLeagueOfChampion_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateLeagueWinner(@Valid @RequestBody LeagueChampionRequest leagueChampionRequest) {

    	ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value())
				.statusMessage(Constants.SUCCESS_MESSAGE).data(leagueService.submitLeagueChampion(leagueChampionRequest)).build();

        
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
