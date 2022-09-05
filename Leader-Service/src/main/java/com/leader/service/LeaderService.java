package com.leader.service;

import com.leader.common.StatusVo;
import com.leader.vo.LeaderVO;

public interface LeaderService {

	StatusVo registerLeaderDetails(LeaderVO leaderVO);

	boolean isLeaderExist(Number leaderId);

	StatusVo deleteLeaderById(Number leaderId);

}
