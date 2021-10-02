package com.digital.factory.controllers;

import com.digital.factory.controllers.response.ApiResponse;
import com.digital.factory.config.Constants;
import com.digital.factory.controllers.request.ParticipantRequest;
import com.digital.factory.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class ParticipantsController {
	@Autowired
	private ParticipantService participantService;

	@GetMapping(Constants.PARTICIPANTS_URL + Constants.numOfGroups_URL)
	public ResponseEntity<?> getParticipantsintoGrouping(@PathVariable Integer numOfGroups) {
		ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value()).statusMessage(Constants.SUCCESS_MESSAGE)
				.data(participantService.groupingParticipants(numOfGroups)).build();
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping(Constants.PARTICIPANTS_URL)
	public ResponseEntity<ApiResponse> getParticipants() {

		ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value()).statusMessage(Constants.SUCCESS_MESSAGE)
				.data(participantService.listAllParticipants()).build();
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping(value = Constants.SUBMIT_PARTICIPANT_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> submitparticipant(@RequestBody ParticipantRequest participantRequest) {

		
		ApiResponse apiResponse = ApiResponse.builder().statusCode(HttpStatus.OK.value()).statusMessage(Constants.SUCCESS_MESSAGE)
				.data(participantService.submitParticipantRequest(participantRequest)).build();
		return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	}

}
