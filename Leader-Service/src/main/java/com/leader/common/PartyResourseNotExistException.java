package com.leader.common;

@SuppressWarnings("serial")
public class PartyResourseNotExistException extends RuntimeException{
	
	public PartyResourseNotExistException(String str) {
		super(str);
	}
}
