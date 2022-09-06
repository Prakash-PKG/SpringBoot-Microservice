package com.leader.vo;

import java.util.List;

public class LeaderAssignTaskRespVo {
	
 private List<AssignTaskVo> assignTaskListVo;
 
 private LeaderVO leaderVO;

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
