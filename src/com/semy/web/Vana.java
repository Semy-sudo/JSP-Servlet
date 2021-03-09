package com.semy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Vana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8"); //사용자에게 보내는 코딩방식
		resp.setContentType("text/html; charset=UTF-8");//사용자의 response header 에 알려줌
		
		PrintWriter out = resp.getWriter();
		

		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		for(int i = 0;i<cnt;i++) {
			out.println("hi");
		}
	}
}
