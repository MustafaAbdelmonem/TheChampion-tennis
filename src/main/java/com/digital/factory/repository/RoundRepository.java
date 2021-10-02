package com.digital.factory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digital.factory.entity.Round;


@Repository
public interface RoundRepository extends CrudRepository<Round, Integer> {

}
