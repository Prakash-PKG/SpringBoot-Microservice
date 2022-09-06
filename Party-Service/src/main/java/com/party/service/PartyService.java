package com.party.service;

import java.util.List;

import com.party.common.StatusVo;
import com.party.vo.LeaderVO;
import com.party.vo.PartyRequectVO;
import com.party.vo.PartyVO;

public interface PartyService {

	StatusVo savePartyDetails(PartyVO partyVO);
	
	PartyRequectVO getPartyDetailsById(PartyRequectVO partyRequectVO);

	StatusVo deletePartyById(Number partyId);

	boolean isPartyExist(Number partyId);

	List<LeaderVO> getAllLeadersParty(Number partyId);
	

}
