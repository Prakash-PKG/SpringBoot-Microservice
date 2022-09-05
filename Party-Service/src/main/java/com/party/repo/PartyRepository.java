package com.party.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.party.entity.PartyEntity;

public interface PartyRepository extends JpaRepository<PartyEntity, Integer>{

}
