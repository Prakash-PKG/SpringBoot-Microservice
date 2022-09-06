package com.leader.vo;

import java.util.List;

import com.leader.common.StatusVo;


public class LeaderTaskAssignReqRespVo {

	private Integer partyId;
	
	 private List<AssignTaskVo> assignTaskListVo;
	 
	 private LeaderVO leaderVO;
	 
	 private StatusVo status;

	public StatusVo getStatus() {
		return status;
	}

	public void setStatus(StatusVo status) {
		this.status = status;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public List<AssignTaskVo> getAssignTaskListVo() {
		return assignTaskListVo;
	}

	public void setAssignTaskListVo(List<AssignTaskVo> assignTaskListVo) {
		this.assignTaskListVo = assignTaskListVo;
	}

	public LeaderVO getLeaderVO() {
		return leaderVO;
	}

	public void setLeaderVO(LeaderVO leaderVO) {
		this.leaderVO = leaderVO;
	}
	 
	 

}
