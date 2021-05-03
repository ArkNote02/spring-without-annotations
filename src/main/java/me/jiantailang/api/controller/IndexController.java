package me.jiantailang.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends AbstractController {

	private static final Logger logger = LogManager.getLogger(IndexController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		logger.info(httpServletRequest.getMethod());
		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		model.addObject("result", "success");
		return model;
	}
}
