package com.digital.factory.repository;

import com.digital.factory.entity.MatchResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchResultRepository extends CrudRepository<MatchResult, Integer> {
}
