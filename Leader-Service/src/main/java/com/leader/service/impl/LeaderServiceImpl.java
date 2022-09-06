package com.leader.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.leader.common.LeadDetailsRespVo;
import com.leader.common.LeaderUtil;
import com.leader.common.StatusVo;
import com.leader.entity.LeaderEntity;
import com.leader.repo.LeaderRepository;
import com.leader.service.LeaderService;
import com.leader.vo.LeaderAssignTaskDetailsVo;
import com.leader.vo.LeaderAssignTaskReqVo;
import com.leader.vo.LeaderAssignTaskRespVo;
import com.leader.vo.LeaderDevelipementTaskReqResp;
import com.leader.vo.LeaderTaskAssignReqRespVo;
import com.leader.vo.LeaderVO;
import com.leader.vo.PartyRequectVO;

@Service
public class LeaderServiceImpl implements LeaderService{

	@Autowired
	private LeaderRepository  leaderRepository;
	
	@Autowired
	private RestTemplate rt;
	
	@Override
	public StatusVo registerLeaderDetails(LeaderVO leaderVO) {
		StatusVo statusVo=new StatusVo();
		PartyRequectVO partyReqVo=new PartyRequectVO();
		partyReqVo.setPartyId(leaderVO.getPartyId());
		partyReqVo.setStatusVo(statusVo);
		try {
		PartyRequectVO status=this.rt.postForObject("http://Party-Service/party/getParty", partyReqVo,PartyRequectVO.class);
		if(status.getStatusVo().getIsSuccess() && status.getStatusVo().getStatusCode()==200 ) {
		LeaderEntity leaderEntity=new LeaderEntity();
		leaderEntity.setLeaderId(leaderVO.getLeaderId());
		leaderEntity.setPartyId(leaderVO.getPartyId());
		leaderEntity.setLeaderName(leaderVO.getLeaderName());
		leaderEntity.setLeaderState(leaderVO.getLeaderState());
		leaderEntity=leaderRepository.save(leaderEntity);
		statusVo=LeaderUtil.getStatusDetails(200,true,"Leader Registred Successfully","");
		}else {
		statusVo=status.getStatusVo();
		}
		}catch(Exception ex) {
			
		}
		return statusVo;
	}

	@Override
	public boolean isLeaderExist(Number leaderId) {
	return leaderRepository.existsById(Integer.parseInt(leaderId.toString()));
		}

	@Override
	public StatusVo deleteLeaderById(Number leaderId) {
		StatusVo status=new StatusVo();
		try {
			leaderRepository.deleteById(Integer.parseInt(leaderId.toString()));
			status=LeaderUtil.getStatusDetails(200,true,"Leader Details Deleted SuccessFully","");
		}catch(Exception Ex) {
			status=LeaderUtil.getStatusDetails(500,false,"Leader Details Deleted Fail due to Internal Server Issue","");
		}
		return status;
	}

	@Override
	public LeaderAssignTaskRespVo getAssignTaskDetails(Number leaderId) {
		LeaderTaskAssignReqRespVo reqResp=new LeaderTaskAssignReqRespVo();
		LeaderAssignTaskRespVo resp=new LeaderAssignTaskRespVo();
		reqResp.setPartyId(Integer.parseInt(leaderId.toString()));
		try {
		 reqResp=this.rt.postForObject("http://Developement-Service/developement/getLeaderAssignTask", reqResp,LeaderTaskAssignReqRespVo.class);
		if(reqResp.getStatus().getIsSuccess() &&reqResp.getStatus().getStatusCode()==200 ) {
			resp.setAssignTaskListVo(reqResp.getAssignTaskListVo());
		
			Optional<LeaderEntity> leadDeyails=leaderRepository.findById(Integer.parseInt(leaderId.toString()));
		    if(leadDeyails.isPresent()) {
		    LeaderVO leadVo=new LeaderVO();	
		    leadVo.setLeaderId(leadDeyails.get().getLeaderId());
		    leadVo.setPartyId(leadDeyails.get().getPartyId());
		    leadVo.setLeaderName(leadDeyails.get().getLeaderName());
		    leadVo.setLeaderState(leadDeyails.get().getLeaderState());
		    resp.setLeaderVO(leadVo);
		    }
		}
		}catch(Exception ex) {
			
		}
		return resp;
	}

	@Override
	public LeadDetailsRespVo getAllLeadersParty(Number partyId) {
		 List<LeaderEntity> leaderList=leaderRepository.getAllLeadersByParty(Integer.parseInt(partyId.toString()));
		 List<LeaderVO> leadList=new ArrayList<>();
		 StatusVo status=new StatusVo();
		 LeadDetailsRespVo leadListVo=new LeadDetailsRespVo();
		 leaderList.forEach(lead->{
			 LeaderVO ldVo=new LeaderVO();	
			 ldVo.setLeaderId(lead.getLeaderId());
			 ldVo.setPartyId(lead.getPartyId());
			 ldVo.setLeaderName(lead.getLeaderName());
			 ldVo.setLeaderState(lead.getLeaderState());
			 leadList.add(ldVo);
		 });
		 status=LeaderUtil.getStatusDetails(200,true,"Leader Details Fetched Successfully","");
		 leadListVo.setStatus(status);
		 leadListVo.setLeadVoList(leadList);
		 
		 return leadListVo;
	}

	@Override
	public boolean isPartyIdExist(Number partyId) {
	   List<LeaderEntity> leaderList=leaderRepository.getAllLeadersByParty(Integer.parseInt(partyId.toString()));
		boolean flag;
	   if(leaderList.size()>0) {
		   flag=true;	
		}else {
		   flag=false;		
		}
	   return flag;
	}

	@Override
	public LeaderAssignTaskDetailsVo getAllDeveloplemetWorkAssignByleader(LeaderAssignTaskReqVo leaderAssignTaskReqVo) {
		LeaderAssignTaskDetailsVo leadAssignTaskVo=new LeaderAssignTaskDetailsVo();
		LeaderDevelipementTaskReqResp reqResp=new LeaderDevelipementTaskReqResp();
		reqResp.setLeaderAssignTaskReqVo(leaderAssignTaskReqVo);
		try {
		 reqResp=this.rt.postForObject("http://Developement-Service/developement/getLeaderDeveloplemetTask", reqResp,LeaderDevelipementTaskReqResp.class);
		 if(reqResp.getLeaderDevelopementList().size()>0) {
		 leadAssignTaskVo.setListDevVo(reqResp.getLeaderDevelopementList());
		 leadAssignTaskVo.setFlag(true);
		 }else {
		 leadAssignTaskVo.setListDevVo(reqResp.getLeaderDevelopementList());
		 leadAssignTaskVo.setFlag(false); 
		 }
		}catch(Exception ex) {
			
		}
		return leadAssignTaskVo;
	
	}
	

}
