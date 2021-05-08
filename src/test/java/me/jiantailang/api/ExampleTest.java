package me.jiantailang.api;

import me.jiantailang.api.util.HmacUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ExampleTest {

	private static final Logger logger = LogManager.getLogger(ExampleTest.class);

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
	public void test1() throws NoSuchAlgorithmException, InvalidKeyException {

		String message = "This is a message.";
		String secretKey = "jiantailang";

		String hash224Message = HmacUtil.hash(secretKey, message, HmacUtil.Algorithm.SHA224);
		logger.info(hash224Message);
		Assert.assertThat(hash224Message, CoreMatchers.is("ef2f61817ef125106bcd6c8181cdb0c2f7a9bfdbeaaa041b675d346c"));

		String hash256Message = HmacUtil.hash(secretKey, message);
		logger.info(hash256Message);
		Assert.assertThat(hash256Message, CoreMatchers.is("4c272f5d34eeb3d5c145bb205848a0826865e4d888dbbded73103252fcdae2df"));

		String hash384Message = HmacUtil.hash(secretKey, message, HmacUtil.Algorithm.SHA384);
		logger.info(hash384Message);
		Assert.assertThat(hash384Message, CoreMatchers.is("4eef56bb2dbc832243e2b2c65b0ab63255d371ad1975f7ef0168653487af06b723828e5713d20a15412a07192aa875a6"));

		String hash512Message = HmacUtil.hash(secretKey, message, HmacUtil.Algorithm.SHA512);
		logger.info(hash512Message);
		Assert.assertThat(hash512Message, CoreMatchers.is("efbe776b09debd953502404769961a41ccccc5533603bac8109e72ba9a3eb0bffde765167a7851c09cfb13e704e8489c40c4f535ed7b8575e87316c9abfbb9e3"));
	}
}
