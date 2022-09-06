package com.leader.common;

import java.util.List;

import com.leader.vo.LeaderVO;


public class LeadDetailsRespVo {

	private Integer partyId;
	
	private List<LeaderVO> leadVoList;
    
	private StatusVo status;

	
	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public List<LeaderVO> getLeadVoList() {
		return leadVoList;
	}

	public void setLeadVoList(List<LeaderVO> leadVoList) {
		this.leadVoList = leadVoList;
	}

	public StatusVo getStatus() {
		return status;
	}

	public void setStatus(StatusVo status) {
		this.status = status;
	}

	
	
	
	
}
