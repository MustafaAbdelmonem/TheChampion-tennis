package com.digital.factory.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digital.factory.entity.League;
import com.digital.factory.entity.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {
    List<Match> findAll();
    List<Match> findAllByRound(Integer round);
    List<Match> findAllByLeagueIdAndRound(League leagueId, Integer round);

     void deleteByRound(Integer integer);
     
     @Query("SELECT Count(*) From Match WHERE date =:date")
     int countMatchesByDate(Date date);
}