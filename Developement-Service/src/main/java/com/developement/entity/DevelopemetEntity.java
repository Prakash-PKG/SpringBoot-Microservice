package com.developement.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="party_leader_dev")
public class DevelopemetEntity implements Serializable{


	private static final long serialVersionUID = -1704803120752690544L;
	
	@Id
	@Column(name="development_id")
	private Integer developemetId;
	
	
	@Column(name="leader_id")
	private Integer leaderId;
	
	
	@Column(name="party_id")
	private Integer partyId;
	
	@Column(name="development_title")
	private String developemetTitle;
	
	@Column(name="activity")
	private String activity;
	
	@Column(name="budget")
	private BigDecimal budget;
	
	@Column(name="state")
	private String state;
	
	@Column(name="active_month")
	private Integer activeMonth;
	
	@Column(name="active_year")
	private Integer activeYear;

	public Integer getDevelopemetId() {
		return developemetId;
	}

	public void setDevelopemetId(Integer developemetId) {
		this.developemetId = developemetId;
	}

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

	public String getDevelopemetTitle() {
		return developemetTitle;
	}

	public void setDevelopemetTitle(String developemetTitle) {
		this.developemetTitle = developemetTitle;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getActiveMonth() {
		return activeMonth;
	}

	public void setActiveMonth(Integer activeMonth) {
		this.activeMonth = activeMonth;
	}

	public Integer getActiveYear() {
		return activeYear;
	}

	public void setActiveYear(Integer activeYear) {
		this.activeYear = activeYear;
	}
	
	

}
