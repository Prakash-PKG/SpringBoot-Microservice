package com.developement.common;

public class DevelopementUtil {



	public static StatusVo getStatusDetails(int statusCode, boolean flag, String message, String exceptMsg) {
		StatusVo status=new StatusVo();
		status.setStatusCode(statusCode);
		status.setIsSuccess(flag);
		status.setMessage(message);
		status.setExceptionMessage(exceptMsg);
		return status;
	}
	



}
