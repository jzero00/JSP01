package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.request.MemberModifyRequest;
import com.jsp.service.MemberServiceImpl;
import com.jsp.util.ViewResolver;

@WebServlet("/member/modify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String id = request.getParameter("id");
		String url = "member/modify";
		
		MemberVO member = null;
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
			request.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500error";
		}
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="member/modify_success";
				
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String picture=request.getParameter("picture");
		String[] phone = request.getParameterValues("phone");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();

		
		try {
			MemberModifyRequest memberReq = new MemberModifyRequest(id, pwd, email, phone, picture, name, address);
			MemberVO member = memberReq.toMemberVO();
			MemberServiceImpl.getInstance().updateMember(member);
			MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
			if(member.getId().equals(loginUser.getId())) {
				session.setAttribute("loginUser", member);
			}
			request.setAttribute("member", member);
		} catch (Exception e) {
			url = "error/500error";
		}
		ViewResolver.view(request, response, url);
	}

}
