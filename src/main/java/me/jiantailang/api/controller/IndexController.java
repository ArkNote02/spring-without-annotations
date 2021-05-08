package me.jiantailang.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexController extends AbstractController {

	private static final Logger logger = LogManager.getLogger(IndexController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession(true); // new session instance
		session.setAttribute("email", request.getParameter("email"));
		response.setHeader("Connection", "close");
		return new ModelAndView("index");
	}
}
