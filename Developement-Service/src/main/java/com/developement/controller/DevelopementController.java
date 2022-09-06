package com.developement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developement.common.StatusVo;
import com.developement.service.DevelopementService;
import com.developement.vo.DevelopementVo;
import com.developement.vo.LeaderDevelipementTaskReqResp;
import com.developement.vo.LeaderTaskAssignReqRespVo;

@RestController
@RequestMapping("/developement")
public class DevelopementController {


	@Autowired
	private DevelopementService developementService;


	@PostMapping(value="/assignTask",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusVo assignTaskToLeader(@RequestBody DevelopementVo developementVo) {
		StatusVo status=developementService.assignTaskDetails(developementVo);
		return status;
	}
	
	@PostMapping(value="/getLeaderAssignTask",produces=MediaType.APPLICATION_JSON_VALUE)
	public LeaderTaskAssignReqRespVo getAssignTaskToLeader(@RequestBody LeaderTaskAssignReqRespVo leaderTaskAssignReqRespVo) {
		LeaderTaskAssignReqRespVo resp=developementService.getAssignTaskToLeader(leaderTaskAssignReqRespVo);
		return resp;
	}
	
	@PostMapping(value="/getLeaderDeveloplemetTask",produces=MediaType.APPLICATION_JSON_VALUE)
	public LeaderDevelipementTaskReqResp getLeaderDeveloplemetTask(@RequestBody LeaderDevelipementTaskReqResp leaderDevelipementTaskReqResp) {
		LeaderDevelipementTaskReqResp resp=developementService.getLeaderDeveloplemetTask(leaderDevelipementTaskReqResp);
		return resp;
	}
	
	

}
