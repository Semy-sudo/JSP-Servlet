package com.semy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {


	@Override
	public void doFilter(ServletRequest req
			, ServletResponse res
			, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before filter");
		req.setCharacterEncoding("UTF-8");//모든 서블릿은 인코딩 환경을 갖게된다음 실행됨
		res.setCharacterEncoding("UTF-8"); //사용자에게 보내는 코딩방식
		res.setContentType("text/html; charset=UTF-8");//사용자의 response header 에 알려줌
		chain.doFilter(req, res);
		System.out.println("hello filter");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
