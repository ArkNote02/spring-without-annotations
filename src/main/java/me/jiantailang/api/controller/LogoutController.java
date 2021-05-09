package me.jiantailang.api.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		if ("POST".equals(method)) {
			return post(request, response);
		} else {
			throw new IllegalAccessException(method + " method is not supported.");
		}
	}

	private ModelAndView post(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Connection", "close");
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("redirect:/login"); // post-redirect-get
	}
}
