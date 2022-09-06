package com.leader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leader.common.LeadDetailsRespVo;
import com.leader.common.LeaderResourseNotExistException;
import com.leader.common.PartyIdandLeadIdNotExistException;
import com.leader.common.StatusVo;
import com.leader.service.LeaderService;
import com.leader.vo.DevelopementVo;
import com.leader.vo.LeaderAssignTaskDetailsVo;
import com.leader.vo.LeaderAssignTaskReqVo;
import com.leader.vo.LeaderAssignTaskRespVo;
import com.leader.vo.LeaderVO;


@RestController
@RequestMapping("/leader")
public class LeaderController {


	@Autowired
	private LeaderService leaderServic;

	@PostMapping(value="/register",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusVo registerLeaderDetails(@RequestBody LeaderVO leaderVO) {
		StatusVo statusVo=leaderServic.registerLeaderDetails(leaderVO);
		return statusVo;
	}	


	@DeleteMapping(value="/deleteParty/{leaderId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusVo deletePartyById(@PathVariable Number leaderId) {
		StatusVo status=null;
		try {
			boolean flag=leaderServic.isLeaderExist(leaderId);
			if(flag) {
				status=leaderServic.deleteLeaderById(leaderId);
			}else {
				throw new LeaderResourseNotExistException("Resource Not Available");
			}
		}catch(Exception ex) {
			throw new LeaderResourseNotExistException("Resource Not Available");
		}
		return status;
	}

	@GetMapping(value="/getAllAssignTask/{leaderId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public LeaderAssignTaskRespVo getAssignTaskDetails(@PathVariable Number leaderId) {

		LeaderAssignTaskRespVo leaderRespDetails=leaderServic.getAssignTaskDetails(leaderId);

		return leaderRespDetails;
	}


	@PostMapping(value="/getAllLeadersParty",produces=MediaType.APPLICATION_JSON_VALUE)
	public LeadDetailsRespVo getAllLeadersParty(@RequestBody LeadDetailsRespVo leadVo) {
		LeadDetailsRespVo leaderList=leaderServic.getAllLeadersParty(leadVo.getPartyId());
		return leaderList;
	}

	@PostMapping(value="/getAllLeadersDevTask",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DevelopementVo> getAllDeveloementWorkAssigntoLeader(@RequestBody LeaderAssignTaskReqVo leaderAssignTaskReqVo){
		LeaderAssignTaskDetailsVo  developementWorkList=null;
		try {
			developementWorkList=leaderServic.getAllDeveloplemetWorkAssignByleader(leaderAssignTaskReqVo);
			if(!developementWorkList.getFlag()) {
				throw new PartyIdandLeadIdNotExistException("Party Id and Leader Id Not Exist");	
			}
		}catch (Exception e) {
			throw new PartyIdandLeadIdNotExistException("Party Id and Leader Id Not Exist");
		}
		return developementWorkList.getListDevVo();

	}



}
