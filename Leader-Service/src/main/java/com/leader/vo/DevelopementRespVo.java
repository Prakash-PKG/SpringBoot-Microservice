package com.leader.vo;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DevelopementRespVo {
	
	private Integer developemetId;
	
	private Integer leaderId;
	
  
	private Integer partyId;
	
  
	private String developemetTitle;
	
   
	private String activity;
	
  
	private BigDecimal budget;

	private String state;
	
 
	private Integer activeMonth;
	

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
