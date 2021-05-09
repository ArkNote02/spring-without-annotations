package me.jiantailang.api.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return get(request, response);
		} else {
			throw new IllegalAccessException(method + " method is not supported.");
		}
	}

	private ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Connection", "close");
		return new ModelAndView("index");
	}
}
