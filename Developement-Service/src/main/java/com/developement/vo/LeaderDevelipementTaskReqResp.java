package com.developement.vo;

import java.util.List;

public class LeaderDevelipementTaskReqResp {
	
private List<DevelopementVo> LeaderDevelopementList;

private LeaderAssignTaskReqVo leaderAssignTaskReqVo;

public List<DevelopementVo> getLeaderDevelopementList() {
	return LeaderDevelopementList;
}

public void setLeaderDevelopementList(List<DevelopementVo> leaderDevelopementList) {
	LeaderDevelopementList = leaderDevelopementList;
}

public LeaderAssignTaskReqVo getLeaderAssignTaskReqVo() {
	return leaderAssignTaskReqVo;
}

public void setLeaderAssignTaskReqVo(LeaderAssignTaskReqVo leaderAssignTaskReqVo) {
	this.leaderAssignTaskReqVo = leaderAssignTaskReqVo;
}




}
