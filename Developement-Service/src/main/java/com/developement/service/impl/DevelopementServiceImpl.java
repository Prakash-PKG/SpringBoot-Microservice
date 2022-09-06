package com.developement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developement.common.DevelopementUtil;
import com.developement.common.StatusVo;
import com.developement.entity.DevelopemetEntity;
import com.developement.repository.DevelopemenetRepository;
import com.developement.service.DevelopementService;
import com.developement.vo.AssignTaskVo;
import com.developement.vo.DevelopementVo;
import com.developement.vo.LeaderDevelipementTaskReqResp;
import com.developement.vo.LeaderTaskAssignReqRespVo;

@Service
public class DevelopementServiceImpl implements DevelopementService{

	
	@Autowired
	private DevelopemenetRepository developemenetRepository;
	
	@Override
	public StatusVo assignTaskDetails(DevelopementVo developementVo) {
		DevelopemetEntity devEntity=new DevelopemetEntity();
		StatusVo status=new StatusVo();
		try {
		devEntity.setDevelopemetId(developementVo.getDevelopemetId());
		devEntity.setPartyId(developementVo.getPartyId());
		devEntity.setLeaderId(developementVo.getLeaderId());
		devEntity.setDevelopemetTitle(developementVo.getDevelopemetTitle());
		devEntity.setActivity(developementVo.getActivity());
		devEntity.setBudget(developementVo.getBudget());
		devEntity.setState(developementVo.getState());
		devEntity.setActiveYear(developementVo.getActiveYear());
		devEntity.setActiveMonth(developementVo.getActiveMonth());
		developemenetRepository.save(devEntity);
		status=DevelopementUtil.getStatusDetails(200, true,"Task Assigned Successfully", "");
		}catch (Exception ex) {
	    status=DevelopementUtil.getStatusDetails(200, true,"Task Assigned Failed Due to Internal Server Issue", "");
		}
		return status;
	}

	@Override
	public LeaderTaskAssignReqRespVo getAssignTaskToLeader(LeaderTaskAssignReqRespVo leaderTaskAssignReqRespVo) {
		LeaderTaskAssignReqRespVo reqResp=new LeaderTaskAssignReqRespVo();
		List<AssignTaskVo> assignTaskList=new ArrayList<>();
		StatusVo status=new StatusVo();
		try {
		List<DevelopemetEntity> devWorkList=developemenetRepository.getAllAssignTaskByLeader(leaderTaskAssignReqRespVo.getLeaderId());
		devWorkList.forEach(p->{
			AssignTaskVo task=new AssignTaskVo();
			task.setDevelopemetTitle(p.getDevelopemetTitle());
			task.setActivity(p.getActivity());
			task.setState(p.getState());
			task.setBudget(p.getBudget());
			task.setActiveMonth(p.getActiveMonth());
			task.setActiveYear(p.getActiveYear());
			assignTaskList.add(task);
		});
		status=DevelopementUtil.getStatusDetails(200, true, "Record fetched successfully", "");
		}catch (Exception ex) {
		status=DevelopementUtil.getStatusDetails(500, false, "Record fetched failed", "");	
		}
		reqResp.setAssignTaskListVo(assignTaskList);
		reqResp.setStatus(status);
		return reqResp;
	}

	@Override
	public LeaderDevelipementTaskReqResp getLeaderDeveloplemetTask(LeaderDevelipementTaskReqResp leaderDevelipementTaskReqResp) {
		List<DevelopementVo> devList=new ArrayList<>();
		LeaderDevelipementTaskReqResp reqResp=new LeaderDevelipementTaskReqResp();
		List<DevelopemetEntity> LeaderDevWorkList=developemenetRepository.getAllAssignTaskByLeaderDevelopement(leaderDevelipementTaskReqResp.getLeaderAssignTaskReqVo().getLeaderId(),leaderDevelipementTaskReqResp.getLeaderAssignTaskReqVo().getPartyId());
		if(LeaderDevWorkList.size()>0) {
			LeaderDevWorkList.forEach(devTask->{
				DevelopementVo devVo=new DevelopementVo();	
				devVo.setDevelopemetId(devTask.getDevelopemetId());
				devVo.setLeaderId(devTask.getLeaderId());
				devVo.setPartyId(devTask.getPartyId());
				devVo.setDevelopemetTitle(devTask.getDevelopemetTitle());
				devVo.setState(devTask.getState());
				devVo.setBudget(devTask.getBudget());
				devVo.setActiveMonth(devTask.getActiveMonth());
				devVo.setActiveYear(devTask.getActiveYear());
				devList.add(devVo);
			});	
			reqResp.setLeaderDevelopementList(devList);
		}
		return reqResp;
	}

}
