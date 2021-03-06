package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;
import com.jsp.util.ViewResolver;

@WebServlet("/member/disabled")
public class MemberDisabledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String url = "member/disabled_success";
		
		HttpSession session = request.getSession();
		if(session == null) {
			url = "member/disabled_denied";
			ViewResolver.view(request, response, url);
			return;
		}
		
		try {
			MemberServiceImpl.getInstance().disableMember(id);
			MemberVO member = MemberServiceImpl.getInstance().getMember(id);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
			url = "member/disabled_fail";
		}
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
