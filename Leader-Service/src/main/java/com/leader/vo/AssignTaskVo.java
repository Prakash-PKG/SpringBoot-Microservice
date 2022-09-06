package com.leader.vo;

import java.math.BigDecimal;

public class AssignTaskVo {

	private String developemetTitle;
	
	private String activity;
	
	private String state;
	
	private BigDecimal budget;
	
	private Integer activeMonth;
	
	private Integer activeYear;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
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
