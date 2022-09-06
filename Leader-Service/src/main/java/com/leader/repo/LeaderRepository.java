package com.leader.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leader.entity.LeaderEntity;


public interface LeaderRepository extends JpaRepository<LeaderEntity, Integer>{

	
	@Query("SELECT l FROM LeaderEntity l where l.partyId=?1 ")
	List<LeaderEntity> getAllLeadersByParty(int partyId);

}
