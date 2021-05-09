package me.jiantailang.api.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return get(request, response);
		} else if ("POST".equals(method)) {
			return post(request, response);
		} else {
			throw new IllegalAccessException(method + " method is not supported.");
		}
	}

	private ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Connection", "close");
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("email") != null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("login");
	}

	private ModelAndView post(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Connection", "close");
		HttpSession session = request.getSession();
		session.invalidate();
		String email = request.getParameter("email");
		// String password = request.getParameter("password");
		// TODO authenticate
		if (email == null || "".equals(email)) {
			return new ModelAndView("redirect:/login"); // post-redirect-get
		}
		String callbackUrl = request.getParameter("callback_url");
		if (callbackUrl == null || "".equals(callbackUrl)) {
			callbackUrl = "/";
		}
		session = request.getSession(true);
		session.setAttribute("email", email);
		return new ModelAndView("redirect:" + callbackUrl); // post-redirect-get
	}
}
