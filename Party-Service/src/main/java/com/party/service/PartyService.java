package com.party.service;

import com.party.common.StatusVo;
import com.party.vo.PartyRequectVO;
import com.party.vo.PartyVO;

public interface PartyService {

	StatusVo savePartyDetails(PartyVO partyVO);
	
	PartyRequectVO getPartyDetailsById(PartyRequectVO partyRequectVO);

	StatusVo deletePartyById(Number partyId);

	boolean isPartyExist(Number partyId);
	

}
