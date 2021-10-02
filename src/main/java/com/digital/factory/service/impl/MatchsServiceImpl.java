package com.digital.factory.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.digital.factory.controllers.request.MatchResultRequest;
import com.digital.factory.entity.Match;
import com.digital.factory.entity.MatchResult;
import com.digital.factory.entity.Participant;
import com.digital.factory.entity.Round;
import com.digital.factory.model.MatchDto;
import com.digital.factory.repository.MatchRepository;
import com.digital.factory.repository.MatchResultRepository;
import com.digital.factory.repository.ParticipantsRepository;
import com.digital.factory.repository.RoundRepository;
import com.digital.factory.service.MatchsService;

@Service
public class MatchsServiceImpl implements MatchsService {
	@Autowired
	private MatchResultRepository matchResultRepository;

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	ParticipantsRepository participantsRepository;
	@Autowired
	RoundRepository roundRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<MatchDto> listMatchesByRound(Integer round) {

		List<Participant> participantList = participantsRepository.findAll();

		List<Match> matches = new ArrayList<>();
		Collections.shuffle(participantList);
		List<List<Participant>> groups = IntStream.range(0, participantList.size()).boxed()
				.collect(Collectors.groupingBy(i -> i % 2)).values().stream()
				.map(il -> il.stream().map(participantList::get).collect(Collectors.toList()))
				.collect(Collectors.toList());

		groups.forEach(participants -> {
			Match match = new Match();
			match.setFirstParticipan(participants.get(0));
			if (participants.get(1) != null)
				match.setSecondParticipant(participants.get(1));
			match.setRound(roundRepository.findById(round).get());
			matchRepository.save(match);
			matches.add(match);
		});

		List<MatchDto> matchDtos = new ArrayList<>();
		if (!CollectionUtils.isEmpty(matches)) {
			matchDtos = matches.stream().map(x -> modelMapper.map(x, MatchDto.class)).collect(Collectors.toList());
		}

		return matchDtos;
	}

	@Override
	@Transactional
	public String updateMatch(MatchResultRequest matchResultRequest) {
	
			MatchResult matchResult = new MatchResult();
			matchResult.setMatch(matchRepository.findById(matchResultRequest.getMatchId()).get());
			matchResult.setWinnerParticipant(
					participantsRepository.findById(matchResultRequest.getWinnerParticipantId()).get());
			matchResult.setLoserParticipant(
					participantsRepository.findById(matchResultRequest.getLoserParticipantId()).get());
			matchResultRepository.save(matchResult);
			return "the match result updated successfully.";
	}

	@Override
	@Transactional
	public String closeRound(Integer roundId) {
		try {
			
			Round round= roundRepository.findById(roundId).get();
			round.setOpen(false);
	
			roundRepository.save(round);
			return "the round closed successfully.";
		} catch (Exception e) {
			return e.getMessage();
		}

	}
}
