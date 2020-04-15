package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.request.MemberJoinRequest;
import com.jsp.service.MemberServiceImpl;
import com.jsp.util.ViewResolver;

@WebServlet("/member/join")
public class MemberJoin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/memberJoin";
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="member/join_success";
				
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String picture=request.getParameter("picture");
		String[] phone = request.getParameterValues("phone");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberJoinRequest memberReq = 
					new MemberJoinRequest(id,pwd,email,phone,picture,name,address);
		
		MemberVO member = memberReq.toMemberVO();
		
		int check = MemberServiceImpl.getInstance().joinMember(member);
		request.setAttribute("name", name);
		if(check != 1) {
			url = "asdasd";
		}
		ViewResolver.view(request, response, url);
	}
}
