package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dao.MemberDaoImpl;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public class MemberServiceImpl implements MemberService {

	private MemberDaoImpl dao;
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		super();
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	@Override
	public int joinMember(MemberVO paramVO) {
		
		return dao.joinMember(paramVO);
	}

	@Override
	public List<MemberVO> getMemberList() {

		return dao.getMemberList();
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIdException, InvalidPasswordException {
		MemberVO member = dao.getMember(id);
		if(member==null) throw new NotFoundIdException();
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
	}

	@Override
	public MemberVO getMember(String id) throws SQLException{

		return dao.getMember(id);
	}

	public void updateMember(MemberVO member) {
		dao.updateMember(member);
	}

	@Override
	public void disableMember(String id) {
		dao.disableMember(id);
	}

	@Override
	public void enableMember(String id) {
		dao.enableMember(id);
	}

}
