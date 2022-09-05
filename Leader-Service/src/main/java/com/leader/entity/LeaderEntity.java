package com.leader.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leader")
public class LeaderEntity implements Serializable{
	

	private static final long serialVersionUID = 113759191732394663L;

	@Id
	@Column(name="leader_id")
	private Integer leaderId;
	
	@Column(name="party_id")
	private Integer partyId;

	@Column(name="leader_name")
	private String leaderName;
	
	@Column(name="leader_state")
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
