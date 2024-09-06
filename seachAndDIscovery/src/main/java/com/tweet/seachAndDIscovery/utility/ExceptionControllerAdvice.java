package com.tweet.seachAndDIscovery.utility;

import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tweet.seachAndDIscovery.exception.SearchAndDiscoveryException;
//import com.tweet.user.exception.UserException;
//import com.tweet.user.utility.ErrorInfo;
//import com.tweet.user.utility.ExceptionControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(SearchAndDiscoveryException.class)
	public ResponseEntity<ErrorInfo> UserExceptionHandler(SearchAndDiscoveryException exception) {
		LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class,ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> validatorExceptionHandler(Exception exception) {
	LOGGER.error(exception.getMessage(), exception);
	String errorMsg;
	if (exception instanceof MethodArgumentNotValidException) {
		MethodArgumentNotValidException manvException = (MethodArgumentNotValidException) exception;
		errorMsg = manvException.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(", "));

	} else {
		ConstraintViolationException cvException = (ConstraintViolationException) exception;
		errorMsg = cvException.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", "));

		LOGGER.error(cvException.getLocalizedMessage());

	}
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
	errorInfo.setErrorMessage(errorMsg);
	return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
}
}
