package com.digital.factory.service.impl;

import com.digital.factory.entity.Participant;
import com.digital.factory.entity.Player;
import com.digital.factory.model.ParticipantDto;
import com.digital.factory.config.Constants;
import com.digital.factory.controllers.request.ParticipantRequest;
import com.digital.factory.model.PlayerDto;
import com.digital.factory.repository.ParticipantsRepository;
import com.digital.factory.repository.PlayerResultRepository;
import com.digital.factory.service.ParticipantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ParticipantServiceImpl implements ParticipantService {
	@Autowired
	ParticipantsRepository participantsRepository;
	@Autowired
	PlayerResultRepository playerResultRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String submitParticipantRequest(ParticipantRequest participantRequest) {

		int nOfParticipants = participantsRepository.countParticipantsByDate(participantRequest.getRegistrationDate());

		if (nOfParticipants < Constants.LimitedParticipants) {

			Player player = playerResultRepository.findById(participantRequest.getPlayerId()).get();
			if (!(participantsRepository.isexistBydate(participantRequest.getRegistrationDate(), player)!=null)) {

				Participant participant = new Participant();
				participant.setPlayer(player);
				participant.setRegistrationDate(participantRequest.getRegistrationDate());
				participantsRepository.save(participant);
				return "participant Submit successfully.";
			}
			else {
				return "This participant participanted in that date.";
			}
		} else {
			return "participant Completed.";
		}
	}

	@Override
	public List<ParticipantDto> listAllParticipants() {

		List<ParticipantDto> participantResponses = new ArrayList<>();

		List<Participant> participantList = participantsRepository.findAll();
		if (!CollectionUtils.isEmpty(participantList)) {
			participantResponses = participantList.stream().map(x -> {
				ParticipantDto participantDto = modelMapper.map(x, ParticipantDto.class);
				PlayerDto playerDto = modelMapper.map(x.getPlayer(), PlayerDto.class);
				participantDto.setPlayer(playerDto);
				return participantDto;
			}).collect(Collectors.toList());
		}

		return participantResponses;
	}

	@Override
	public List<List<ParticipantDto>> groupingParticipants(int numOfGroups) {
		List<ParticipantDto> participantDtos = listAllParticipants();

		Collections.shuffle(participantDtos);
		List<List<ParticipantDto>> groups = IntStream.range(0, participantDtos.size()).boxed()
				.collect(Collectors.groupingBy(i -> i % numOfGroups)).values().stream()
				.map(il -> il.stream().map(participantDtos::get).collect(Collectors.toList()))
				.collect(Collectors.toList());
		return groups;
	}
}
