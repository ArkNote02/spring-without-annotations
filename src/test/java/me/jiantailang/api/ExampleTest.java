package me.jiantailang.api;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ExampleTest {

	@Mock
	private Appender appender;

	@Captor
	ArgumentCaptor<LogEvent> logEventCaptor;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(appender.getName()).thenReturn("Test");
		Mockito.when(appender.isStarted()).thenReturn(true);
		Mockito.when(appender.isStopped()).thenReturn(false);
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		LoggerConfig loggerConfig = ctx.getConfiguration().getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
		loggerConfig.removeAppender("Console"); // as you like
		loggerConfig.addAppender(appender, Level.INFO, null);
		ctx.updateLoggers();
	}

	@Test
	public void test1() {
		String message = "This is a test message.";
		Example example = new Example();
		example.info(message);
		Mockito.verify(appender, Mockito.times(1)).append(logEventCaptor.capture());
		LogEvent logEvent = logEventCaptor.getValue();
		Assert.assertThat(logEvent.getLevel(), CoreMatchers.is(Level.INFO));
		Assert.assertThat(logEvent.getMessage().getFormattedMessage(), CoreMatchers.is(message));
	}
}
