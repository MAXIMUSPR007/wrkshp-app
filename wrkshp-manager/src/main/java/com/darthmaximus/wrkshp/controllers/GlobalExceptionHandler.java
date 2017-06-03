package com.darthmaximus.wrkshp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.darthmaximus.wrkshp.models.AlertsModel;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	public static final String DEFAULT_ERROR_VIEW = "error";
 
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    // If the exception is annotated with @ResponseStatus rethrow it and let
	    // the framework handle it - like the OrderNotFoundException example
	    // at the start of this post.
	    // AnnotationUtils is a Spring Framework utility class.
	    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
	    	throw e;
	    }

	    log.error("An exception ocurred: " + e);

	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("alerts", 
	    	AlertsModel.Code.EXCEPTION.getAlert()
	    		.url(req.getRequestURL().toString())
	    		.entry(e.getMessage()));
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return mav;
	}
}
