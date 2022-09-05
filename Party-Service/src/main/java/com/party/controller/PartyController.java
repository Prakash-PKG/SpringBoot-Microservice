package com.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.party.common.PartyResourseNotExistException;
import com.party.common.StatusVo;
import com.party.service.PartyService;
import com.party.vo.PartyRequectVO;
import com.party.vo.PartyVO;

@RestController
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyService partyService;

	@PostMapping(value="/register",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusVo registerPartyDetails(@RequestBody PartyVO partyVO) {
	StatusVo statusVo=partyService.savePartyDetails(partyVO);
	return statusVo;
	}
	
	@PostMapping("/getParty")
	public PartyRequectVO getPartyDetails(@RequestBody PartyRequectVO PartyRequectVO) {
	PartyRequectVO statusVo=partyService.getPartyDetailsById(PartyRequectVO);
	return statusVo;
	}
	
	
	@DeleteMapping(value="/deleteParty/{partyId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusVo deletePartyById(@PathVariable Number partyId) {
	StatusVo status=null;
	try {
	 boolean flag=partyService.isPartyExist(partyId);
	 if(flag) {
	 status=partyService.deletePartyById(partyId);
	 }else {
	  throw new PartyResourseNotExistException("Resource Not Available");
	 }
	}catch(Exception ex) {
		 throw new PartyResourseNotExistException("Resource Not Available");
	}
	 return status;
	}
	 

	}