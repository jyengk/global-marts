package com.sn.core.model;

/**
 * Model object to hold custom error code and error message
 * @author jianni.yengkhom
 *
 */
public class ErrorModel {
	
	private String errorCode;
	private String message;
	
	void ErrorCode(String errorCode, String message){
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
