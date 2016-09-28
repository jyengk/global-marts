package com.sn.core.model;

import java.util.ArrayList;
import java.util.List;

//TODO - add @Json
public class ErrorResponseModel {

	private List<ErrorModel> errors;

	public List<ErrorModel> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorModel> errors) {
		this.errors = errors;
	}
	
	public void addError(String code, String message){
		if(errors == null){
			errors = new ArrayList<ErrorModel>();
		}
		ErrorModel model = new ErrorModel();
		model.setErrorCode(code);
		model.setMessage(message);
		errors.add(model);
	}
	
}
