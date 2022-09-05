package com.leader.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LeaderVO {
	
	@Pattern(regexp ="^[0-9]+$")
	@NotNull
	private Integer leaderId;
	
	@Pattern(regexp ="^[0-9]+$")
	@NotNull
	private Integer partyId;
	
	@NotNull
	@Size(min=5,max=100)
	private String leaderName;
	
	@NotNull
	@Size(min=5,max=100)
	private String leaderState;

	public Integer getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderState() {
		return leaderState;
	}

	public void setLeaderState(String leaderState) {
		this.leaderState = leaderState;
	}

	
	
}
