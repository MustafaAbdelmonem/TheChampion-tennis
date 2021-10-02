package com.digital.factory.repository;

import com.digital.factory.entity.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeagueRepository extends CrudRepository<League, Integer> {

}
