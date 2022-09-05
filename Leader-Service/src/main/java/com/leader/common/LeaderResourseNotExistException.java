package com.leader.common;

@SuppressWarnings("serial")
public class LeaderResourseNotExistException extends RuntimeException{
	
	public LeaderResourseNotExistException(String str) {
		super(str);
	}

}
