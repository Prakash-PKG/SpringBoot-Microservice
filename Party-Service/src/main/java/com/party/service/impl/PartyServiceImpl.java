package com.party.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.party.common.PartyUtil;
import com.party.common.StatusVo;
import com.party.entity.PartyEntity;
import com.party.repo.PartyRepository;
import com.party.service.PartyService;
import com.party.vo.PartyRequectVO;
import com.party.vo.PartyVO;

@Service
public class PartyServiceImpl implements PartyService{

	@Autowired
	private PartyRepository partyRepository;
	
	@Override
	public StatusVo savePartyDetails(PartyVO partyVO) {
		StatusVo statusVo=new StatusVo();
		try {
		PartyEntity partyEntity=new PartyEntity();
		partyEntity.setPartyId(partyVO.getPartyId());
		partyEntity.setPartyName(partyVO.getPartyName());
		partyEntity.setFounderName(partyVO.getFounderName());
		partyEntity.setFounderYear(partyVO.getFounderYear());
		partyEntity=partyRepository.save(partyEntity);
		statusVo=PartyUtil.getStatusDetails(200,true,"Party Registred Successfully","");
		}catch(Exception ex) {
			
		}
		return statusVo;
	}

	@Override
	public PartyRequectVO getPartyDetailsById(PartyRequectVO partyRequectVO) {
		PartyRequectVO statusVo=new PartyRequectVO();
		StatusVo status=new StatusVo();
		Optional<PartyEntity> party= partyRepository.findById(partyRequectVO.getPartyId());
		if(party.isPresent()) {
			status=PartyUtil.getStatusDetails(200,true,"Party Already Registred","");	
			statusVo.setStatusVo(status);
			statusVo.setPartyId(partyRequectVO.getPartyId());
		}else {
			status=PartyUtil.getStatusDetails(404,false,"Party Need to Register Before Leader Registaration","");	
			statusVo.setStatusVo(status);
			statusVo.setPartyId(partyRequectVO.getPartyId());
		}
		return statusVo;
	}

	@Override
	public StatusVo deletePartyById(Number partyId) {
		StatusVo status=new StatusVo();
		try {
			partyRepository.deleteById(Integer.parseInt(partyId.toString()));
			status=PartyUtil.getStatusDetails(200,true,"Party Details Deleted SuccessFully","");
		}catch(Exception Ex) {
			status=PartyUtil.getStatusDetails(500,false,"Party Details Deleted Fail due to Internal Server Issue","");
		}
		return status;
	}

	@Override
	public boolean isPartyExist(Number partyId) {
		return partyRepository.existsById(Integer.parseInt(partyId.toString()));
	}

}
