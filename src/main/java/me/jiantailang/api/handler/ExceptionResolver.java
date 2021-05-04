package me.jiantailang.api.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {

	private static final Logger logger = LogManager.getLogger(ExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
		logger.error("An unexpected exception has occurred.", e);
		response.setHeader("Connection", "close");
		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		model.setStatus(e instanceof NoHandlerFoundException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST);
		model.addObject("result", "error");
		return model;
	}
}
