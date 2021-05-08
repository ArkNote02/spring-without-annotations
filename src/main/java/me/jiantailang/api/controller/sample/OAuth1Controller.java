package me.jiantailang.api.controller.sample;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class OAuth1Controller extends AbstractController {

	/*
	 * [Required]
	 * Request Header
	 * ・Authorization: Bearer {base64_encoded_token}
	 * Request Parameter
	 * ・phone_number
	 * ・password
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String authorization = request.getHeader("Authorization");
		if (authorization == null || "".equals(authorization)) {
			throw new Exception("Authorization Header is not set.");
		}
		String[] authorizationElements = authorization.split(" ");
		if (authorizationElements.length != 2) {
			throw new Exception("Authorization Header is illegal format.");
		}
		if (!"Bearer".equals(authorizationElements[0])) {
			throw new Exception("Scheme in Authorization Header is not OAuth.");
		}
		String token = new String(Base64.getDecoder().decode(authorizationElements[1]));
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");

		// TODO authorize

		return null;
	}
}
