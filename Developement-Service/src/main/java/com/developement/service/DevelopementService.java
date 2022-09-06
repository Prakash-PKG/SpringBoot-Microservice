package com.developement.service;

import com.developement.common.StatusVo;
import com.developement.vo.DevelopementVo;
import com.developement.vo.LeaderDevelipementTaskReqResp;
import com.developement.vo.LeaderTaskAssignReqRespVo;

public interface DevelopementService {

	StatusVo assignTaskDetails(DevelopementVo developementVo);

	LeaderTaskAssignReqRespVo getAssignTaskToLeader(LeaderTaskAssignReqRespVo leaderTaskAssignReqRespVo);

	LeaderDevelipementTaskReqResp getLeaderDeveloplemetTask(LeaderDevelipementTaskReqResp leaderDevelipementTaskReqResp);

}
