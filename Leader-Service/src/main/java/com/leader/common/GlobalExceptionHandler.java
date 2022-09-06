package com.leader.common;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LeaderResourseNotExistException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(LeaderResourseNotExistException ex) {
		ExceptionResponse exRespstatus=new ExceptionResponse();
		exRespstatus.setStatusCode(HttpStatus.SC_NOT_FOUND);
		exRespstatus.setIsSuccess(false);
		exRespstatus.setMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(exRespstatus,null, HttpStatus.SC_NOT_FOUND);
	}

	
	@ExceptionHandler(PartyResourseNotExistException.class)
	public ResponseEntity<ExceptionResponse> partyResourceNotFound(PartyResourseNotExistException ex) {
		ExceptionResponse exRespstatus=new ExceptionResponse();
		exRespstatus.setStatusCode(HttpStatus.SC_NOT_FOUND);
		exRespstatus.setIsSuccess(false);
		exRespstatus.setMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(exRespstatus,null, HttpStatus.SC_NOT_FOUND);
	}
	
	
	@ExceptionHandler(PartyIdandLeadIdNotExistException.class)
	public ResponseEntity<ExceptionResponse> partyIdandLeaderIdResourceNotFound(PartyIdandLeadIdNotExistException ex) {
		ExceptionResponse exRespstatus=new ExceptionResponse();
		exRespstatus.setStatusCode(HttpStatus.SC_NOT_FOUND);
		exRespstatus.setIsSuccess(false);
		exRespstatus.setMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(exRespstatus,null, HttpStatus.SC_NOT_FOUND);
	}
	

}
