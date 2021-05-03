package me.jiantailang.api.batch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.jiantailang.api.service.Service;

public class ExampleBatch {

	private static final Logger logger = LogManager.getLogger(ExampleBatch.class);

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			Service service = (Service) context.getBean("exampleService");
			service.serve();
		} catch (Exception e) {
			logger.error("An unexpected exception has occurred", e);
		}
	}
}
