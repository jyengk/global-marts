package com.sn.core.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.fasterxml.jackson.core.JsonParseException;
import com.sn.core.exception.ResourceNotFoundException;
import com.sn.core.exception.UnauthorizedException;
import com.sn.core.model.ErrorResponseModel;

/**
 * Base rest for exception handler
 * TODO - Move the error code to an ENUM
 * @author jianni.yengkhom
 *
 */
public class BaseRest {
	
	Logger log = LoggerFactory.getLogger(BaseRest.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponseModel genericError(HttpServletRequest request, 
										HttpServletResponse response, 
										Exception exception){
		ErrorResponseModel model = new ErrorResponseModel();
		model.addError("SERVICE_ERROR", exception.getLocalizedMessage());
		return model;
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
	public ErrorResponseModel genericAuthError(HttpServletRequest request, 
										HttpServletResponse response, 
										Exception exception){
		ErrorResponseModel model = new ErrorResponseModel();
		model.addError("UNAUTHORIZED", exception.getLocalizedMessage());
		return model;
	}
	
	@ExceptionHandler({HttpMessageNotReadableException.class,
				        HttpMediaTypeNotSupportedException.class,
				        HttpMessageConversionException.class,
				        JsonParseException.class,
				      //	  JsonMappingException.class,
				        NoHandlerFoundException.class,
				        NoSuchRequestHandlingMethodException.class,
				        HttpRequestMethodNotSupportedException.class,
				        ResourceNotFoundException.class})
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public ErrorResponseModel messageNotReadableError(HttpServletRequest request,
	                        HttpServletResponse response, Exception exception) {
        log.error("", exception);
        ErrorResponseModel resource = new ErrorResponseModel();
        resource.addError("INVALID_VALUE", exception.getLocalizedMessage());
        return resource;
	}
}
