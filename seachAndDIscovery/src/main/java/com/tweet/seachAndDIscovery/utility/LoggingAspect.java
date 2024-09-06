package com.tweet.seachAndDIscovery.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.tweet.seachAndDIscovery.exception.SearchAndDiscoveryException;

//import com.tweet.user.exception.UserException;
//import com.tweet.user.utility.LoggingAspect;

@Aspect
@Component
public class LoggingAspect {
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.tweet.seachAndDIscovery.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(SearchAndDiscoveryException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
}
