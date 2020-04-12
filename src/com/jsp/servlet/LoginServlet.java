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
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;
import com.jsp.service.MemberServiceImpl;
import com.jsp.util.ViewResolver;

@WebServlet("/common/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/common/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "redirect:/common/main";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		//로그인 처리부
		try {
			MemberServiceImpl.getInstance().login(id, pwd);
			
			MemberVO loginUser = MemberServiceImpl.getInstance().getMember(id);
			session.setAttribute("loginUser", loginUser);
		} catch (SQLException e) {
			//로그인 실패
			e.printStackTrace();
			url = "error/500_error";
			request.setAttribute("exception", e);		
		} catch (NotFoundIdException | InvalidPasswordException e) {
			e.printStackTrace();
			url = "common/loginForm";
			request.setAttribute("msg", e.getMessage());
		}
		
		ViewResolver.view(request, response, url);
	}

}
