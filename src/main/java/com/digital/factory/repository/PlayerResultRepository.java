package com.digital.factory.repository;

import com.digital.factory.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PlayerResultRepository extends CrudRepository<Player, Integer> {

}
