package com.leader.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.leader.common.LeaderUtil;
import com.leader.common.StatusVo;
import com.leader.entity.LeaderEntity;
import com.leader.repo.LeaderRepository;
import com.leader.service.LeaderService;
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
	

}