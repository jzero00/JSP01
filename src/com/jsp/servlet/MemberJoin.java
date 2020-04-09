package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

@WebServlet("/member/regist")
public class MemberJoin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService member = MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/regist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String url = "/WEB-INF/views/common/join_success.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwdcheck = request.getParameter("pwdcheck");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String name = request.getParameter("name");
		
		MemberVO paramVO = new MemberVO();
		paramVO.setAddress(address);
		paramVO.setEmail(email);
		paramVO.setEnabled(1);
		paramVO.setId(id);
		paramVO.setName(name);
		paramVO.setPhone(phone);
		paramVO.setPicture(picture);
		paramVO.setPwd(pwd);
		int check = member.joinMember(paramVO);
		
		if(check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", paramVO);
		} else {
			url = "asdasd.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
