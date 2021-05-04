package me.jiantailang.api.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LogStartEndProxy {

	private static final Logger logger = LogManager.getLogger(LogStartEndProxy.class);

	public void logStart(JoinPoint jp) {
		String cName = jp.getTarget().getClass().getName();
		String mName = jp.getSignature().getName();
		logger.info("start " + cName + "#" + mName + "()");
	}

	public void logEnd(JoinPoint jp) throws Throwable {
		String cName = jp.getTarget().getClass().getName();
		String mName = jp.getSignature().getName();
		logger.info("end " + cName + "#" + mName + "()");
	}
}
