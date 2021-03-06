package com.semy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();//현재 접속한 사용자
		Cookie[] cookies = req.getCookies();
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
			//int x = (Integer)application.getAttribute("value");//값을 꺼내옴
			//int x = (Integer)session.getAttribute("value");//값을 꺼내옴
			int x = 0;
			for(Cookie c:cookies) 
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());	
					break;
				}
					
			
			int y = v;
			
			String operator = "";
			for(Cookie c:cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();	
					break;
				}
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;	

			
			resp.getWriter().printf("result is %d\n",result);
		}
		//저장
		else {
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);	
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);	
		
			Cookie valueCookie = new Cookie("value",String.valueOf(v));
			Cookie opCookie = new Cookie("op",op);
			
			valueCookie.setPath("/");
			opCookie.setPath("/");
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
			
			resp.sendRedirect("calc2.html");
		}
		
		
		
	}
}
