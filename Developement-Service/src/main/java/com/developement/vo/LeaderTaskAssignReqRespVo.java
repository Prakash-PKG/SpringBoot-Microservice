package com.developement.vo;

import java.util.List;

import com.developement.common.StatusVo;

public class LeaderTaskAssignReqRespVo {

	 private Integer leaderId;
	
	 private List<AssignTaskVo> assignTaskListVo;
	 
	 private StatusVo status;

	public Integer getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public List<AssignTaskVo> getAssignTaskListVo() {
		return assignTaskListVo;
	}

	public void setAssignTaskListVo(List<AssignTaskVo> assignTaskListVo) {
		this.assignTaskListVo = assignTaskListVo;
	}

	public StatusVo getStatus() {
		return status;
	}

	public void setStatus(StatusVo status) {
		this.status = status;
	}

	
	 
	 

}
