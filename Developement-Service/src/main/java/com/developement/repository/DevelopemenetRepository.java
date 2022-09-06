package com.developement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.developement.entity.DevelopemetEntity;

public interface DevelopemenetRepository extends JpaRepository<DevelopemetEntity,Integer> {

	@Query("SELECT d FROM DevelopemetEntity d where d.leaderId=?1 order by activeYear desc ")
	List<DevelopemetEntity> getAllAssignTaskByLeader(Integer leaderId);

	
	@Query("SELECT d FROM DevelopemetEntity d where d.leaderId=?1 and d.partyId=?2 ")
	List<DevelopemetEntity> getAllAssignTaskByLeaderDevelopement(Integer leaderId, Integer partyId);

}
