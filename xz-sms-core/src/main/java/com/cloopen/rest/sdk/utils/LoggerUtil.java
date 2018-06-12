package com.cloopen.rest.sdk.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloopen.rest.sdk.CCPRestSmsSDK;


public class LoggerUtil {
	private static boolean isLog = true;
	private static Logger logger;
	static {
		if (logger == null) {
			logger = LoggerFactory.getLogger(CCPRestSmsSDK.class);
			
		}
	}
	 
	public static void setLogger(boolean isLog) {
		LoggerUtil.isLog = isLog;
	}
	public static void setLog(Logger logger) {
		LoggerUtil.logger = logger;
	}
	
	public static void setLogLevel(int level) {
		if (logger == null) {
			logger = LoggerFactory.getLogger(CCPRestSmsSDK.class);
		}
		 


	}

	public static void debug(Object msg) {
		if (isLog)
			logger.debug(new Date()+" "+msg);
	}

	public static void info(Object msg) {
		if (isLog)
			logger.info(new Date()+" "+msg);
	}

	public static void warn(Object msg) {
		if (isLog)
			logger.warn((String) msg);
	}

	public static void error(Object msg) {
		if (isLog)
			logger.error((String) msg);
	}

	  
}
