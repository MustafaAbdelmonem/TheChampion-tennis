package com.digital.factory.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.config.Constants;
import com.digital.factory.controllers.request.LeagueChampionRequest;
import com.digital.factory.controllers.request.MatchRequest;
import com.digital.factory.entity.League;
import com.digital.factory.entity.Match;
import com.digital.factory.entity.Participant;
import com.digital.factory.model.MatchDto;
import com.digital.factory.repository.LeagueRepository;
import com.digital.factory.repository.MatchRepository;
import com.digital.factory.repository.ParticipantsRepository;
import com.digital.factory.repository.RoundRepository;
import com.digital.factory.service.LeagueService;
import com.digital.factory.service.MailSender;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeagueServiceImpl implements LeagueService {
	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private ParticipantsRepository participantsRepository;

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private RoundRepository roundRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public String submitLeagueChampion(LeagueChampionRequest leagueChampionRequest) {
		League league = leagueRepository.findById(leagueChampionRequest.getLeagueId()).get();
		Participant participant = participantsRepository.findById(leagueChampionRequest.getChampionId()).get();
		league.setChampionId(participant);
		leagueRepository.save(league);
		mailSender.sendEmail(participant.getPlayer().getEmail());
		return "League champion updated successfully.";

	}

	@Override
	@Transactional
	public String submitRequestMatch(MatchRequest matchRequest) {

		int nOfMatches = matchRepository.countMatchesByDate(matchRequest.getDate());
		if (nOfMatches <= Constants.LimitedMathces) {
			Match match = new Match();
			match.setDate(matchRequest.getDate());
			match.setFirstParticipan(participantsRepository.findById(matchRequest.getFirstParticipanId()).get());
			match.setSecondParticipant(participantsRepository.findById(matchRequest.getSecondParticipantId()).get());
			match.setRound(roundRepository.findById(matchRequest.getRoundId()).get());
			match.setLeague(leagueRepository.findById(matchRequest.getLeagueId()).get());
			matchRepository.save(match);
			return "Match Submit successfully.";
		}else
			return "Matches completed ";

	}
}
