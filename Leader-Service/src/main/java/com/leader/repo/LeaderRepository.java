package com.leader.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leader.entity.LeaderEntity;


public interface LeaderRepository extends JpaRepository<LeaderEntity, Integer>{

}
