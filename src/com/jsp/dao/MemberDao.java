package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberDao {

	public MemberVO login(String id, String pwd);
	
	public int joinMember(MemberVO paramVO);

	public List<MemberVO> getMemberList();

	MemberVO getMember(String id) throws SQLException;

	public void updateMember(MemberVO member);
	
	public void disableMember(String id);
	
	public void enableMember(String id);
	
}
