package com.digital.factory.repository;

import com.digital.factory.entity.Participant;
import com.digital.factory.entity.Player;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ParticipantsRepository extends CrudRepository<Participant, Integer> {
	List<Participant> findAll();

	@Query("SELECT Count(*) From Participant WHERE registrationDate =:registrationDate")
	int countParticipantsByDate(Date registrationDate);

    @Query("SELECT p From Participant p WHERE  registrationDate =:registrationDate AND player =:player")
    Participant isexistBydate(Date registrationDate,Player player);
}
