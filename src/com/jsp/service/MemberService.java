package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public interface MemberService {

	public void login(String id, String pwd) throws SQLException, NotFoundIdException, InvalidPasswordException;
	
	public MemberVO getMember(String id) throws SQLException;;
	
	public int joinMember(MemberVO paramVO);

	public List<MemberVO> getMemberList();
	
}
