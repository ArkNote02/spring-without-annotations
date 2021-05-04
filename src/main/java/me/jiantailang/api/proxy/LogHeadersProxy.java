package me.jiantailang.api.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

public class LogHeadersProxy implements HandlerInterceptor {

	private static final Logger logger = LogManager.getLogger(LogHeadersProxy.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String name = headerNames.nextElement();
				logger.info("RequestHeader " + name + ": " + request.getHeader(name));
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Collection<String> headerNames = response.getHeaderNames();
		if (headerNames != null) {
			for (String headerName : headerNames) {
				logger.info("ResponseHeader " + headerName + ": " + response.getHeader(headerName));
			}
		}
	}
}
