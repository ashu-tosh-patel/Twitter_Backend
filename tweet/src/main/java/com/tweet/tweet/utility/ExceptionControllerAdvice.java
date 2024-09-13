package com.tweet.tweet.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tweet.tweet.exception.TweetException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {

		ErrorMessage error = new ErrorMessage();
		error.setErrCode(HttpStatus.BAD_REQUEST.value());
		error.setErrMessage(ex.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", ")));
		error.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintValidationExceptions(ConstraintViolationException ex) {

		ErrorMessage error = new ErrorMessage();
		error.setErrCode(HttpStatus.BAD_REQUEST.value());
		error.setErrMessage(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", ")));
		error.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TweetException.class)
	public ResponseEntity<ErrorMessage> handleExceptions(TweetException exception) {

		ErrorMessage error = new ErrorMessage();
		error.setErrCode(HttpStatus.BAD_REQUEST.value());
		error.setErrMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleExceptions(Exception exception) {

		ErrorMessage error = new ErrorMessage();
		error.setErrCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrMessage("Something went Wrong!!!!!!!" + exception.getMessage());
		error.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
