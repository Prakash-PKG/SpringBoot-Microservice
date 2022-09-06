package com.party.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.party.common.PartyUtil;
import com.party.common.StatusVo;
import com.party.entity.PartyEntity;
import com.party.repo.PartyRepository;
import com.party.service.PartyService;
import com.party.vo.LeadDetailsRespVo;
import com.party.vo.LeaderVO;
import com.party.vo.PartyRequectVO;
import com.party.vo.PartyVO;

@Service
public class PartyServiceImpl implements PartyService{

	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private RestTemplate rt;
	
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

	@Override
	public List<LeaderVO> getAllLeadersParty(Number partyId) {
		LeadDetailsRespVo reqResp=new LeadDetailsRespVo();
		List<LeaderVO> ldVo=new ArrayList<>();
		reqResp.setPartyId(Integer.parseInt(partyId.toString()));
		try {
		 reqResp=this.rt.postForObject("http://Leader-Service/leader/getAllLeadersParty", reqResp,LeadDetailsRespVo.class);
		if(reqResp.getStatus().getIsSuccess() &&reqResp.getStatus().getStatusCode()==200 ) {
			ldVo=reqResp.getLeadVoList();
		    }
		
		}catch(Exception ex) {
			
		}
		return ldVo;
	}

}
