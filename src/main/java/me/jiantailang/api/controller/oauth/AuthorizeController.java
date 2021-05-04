package me.jiantailang.api.controller.oauth;

import me.jiantailang.api.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizeController extends AbstractController {

	private static final Logger logger = LogManager.getLogger(AuthorizeController.class);

	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hosts = request.getHeader("Hosts");
		String userAgent = request.getHeader("User-Agent");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// TODO service.serve();

		response.setHeader("Connection", "close");
		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		model.addObject("oauth_token", "123456789012345678901234567890");
		model.addObject("oauth_token_secret", "012345678901234567890123456789");
		return model;
	}
}
