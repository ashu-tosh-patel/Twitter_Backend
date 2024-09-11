package com.tweet.tweet.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.tweet.tweet.exception.TweetException;

@Component
@Aspect
public class LoggingAspect {
	public static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.tweet.tweet.service.*Impl.*(..))", throwing = "exception")
	public void logExceptionFromService(TweetException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
}
