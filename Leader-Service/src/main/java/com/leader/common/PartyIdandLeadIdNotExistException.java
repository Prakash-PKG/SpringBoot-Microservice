package com.leader.common;

@SuppressWarnings("serial")
public class PartyIdandLeadIdNotExistException extends RuntimeException{
	
	public PartyIdandLeadIdNotExistException(String str) {
		super(str);
	}
}
