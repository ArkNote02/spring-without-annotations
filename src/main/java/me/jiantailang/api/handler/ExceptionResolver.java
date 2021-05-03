package me.jiantailang.api.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {

	private static final Logger logger = LogManager.getLogger(ExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
		logger.error("An unexpected exception has occurred.", e);
		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		model.addObject("result", "error");
		return model;
	}
}
