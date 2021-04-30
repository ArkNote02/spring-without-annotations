package me.jiantailang.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Example {

	private static final Logger logger = LogManager.getLogger(Example.class);

	public void info(String message) {
		logger.info(message);
	}
}
