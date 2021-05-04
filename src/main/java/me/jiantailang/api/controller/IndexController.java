package me.jiantailang.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class IndexController extends AbstractController {

	private static final Logger logger = LogManager.getLogger(IndexController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String name = headerNames.nextElement();
				logger.info(name + ": " + request.getHeader(name));
			}
		}

		response.setHeader("Connection", "close");
		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		model.addObject("result", "success");
		return model;
	}
}
