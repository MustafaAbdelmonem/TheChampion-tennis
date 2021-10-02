package com.digital.factory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.config.Constants;
import com.digital.factory.controllers.request.CloseRoundRequest;
import com.digital.factory.controllers.request.MatchResultRequest;
import com.digital.factory.controllers.response.ApiResponse;
import com.digital.factory.service.MatchsService;

@RestController()
public class MatchController {

	@Autowired
	private MatchsService matchsService;

	@GetMapping(Constants.MATCHES_List_URL)
	public ResponseEntity<?> getMatchesByRound(@PathVariable Integer round) {

		ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value())
				.statusMessage(Constants.SUCCESS_MESSAGE).data(matchsService.listMatchesByRound(round)).build();

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping(value = Constants.MATCHES_URL,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMatchWinner(@PathVariable Integer matchId,
			@RequestBody MatchResultRequest matchResultRequest) {
		ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value())
				.statusMessage(Constants.SUCCESS_MESSAGE).data(matchsService.updateMatch(matchResultRequest)).build();
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping(value = Constants.CLOSE_ROUND_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> closeRound(@RequestBody CloseRoundRequest closeRoundRequest) {

		ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value())
				.statusMessage(Constants.SUCCESS_MESSAGE)
				.data(matchsService.closeRound(closeRoundRequest.getRoundId())).build();
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
