package com.leader.service;

import java.util.List;

import com.leader.common.LeadDetailsRespVo;
import com.leader.common.StatusVo;
import com.leader.vo.LeaderAssignTaskDetailsVo;
import com.leader.vo.LeaderAssignTaskReqVo;
import com.leader.vo.LeaderAssignTaskRespVo;
import com.leader.vo.LeaderVO;

public interface LeaderService {

	StatusVo registerLeaderDetails(LeaderVO leaderVO);

	boolean isLeaderExist(Number leaderId);

	StatusVo deleteLeaderById(Number leaderId);

	LeaderAssignTaskRespVo getAssignTaskDetails(Number leaderId);

	LeadDetailsRespVo getAllLeadersParty(Number partyId);

	boolean isPartyIdExist(Number partyId);

	LeaderAssignTaskDetailsVo getAllDeveloplemetWorkAssignByleader(LeaderAssignTaskReqVo leaderAssignTaskReqVo);

}
