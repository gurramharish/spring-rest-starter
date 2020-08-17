package com.hans.srs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hans.srs.exception.ErrorCode;
import com.hans.srs.exception.SRSException;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("In authentication interceptor ::: ");
		String token = request.getHeader("x-user-token");
		if(!"123456789".equals(token)) {
			throw new SRSException("User Token not found or invalid", HttpStatus.UNAUTHORIZED, ErrorCode.UNAUTHORIZED_ACCESS);
		}
		return true;
	}
	
}
