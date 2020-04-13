package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jsp.dto.MemberVO;
import com.jsp.util.SqlMapClientFactory;

public class MemberDaoImpl implements MemberDao {

	private SqlMapClient smc;
	
	private static MemberDaoImpl dao;
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	@Override
	public int joinMember(MemberVO paramVO) {
		int check = 0;
		try {
			smc.insert("member.join", paramVO);
			check = 1;
		} catch (SQLException e) {
			check = 0;
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = null;
		try {
			memberList = (List<MemberVO>) smc.queryForList("member.getMemberList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public MemberVO login(String id, String pwd) {
		MemberVO res = null;
		try {
			res = (MemberVO) smc.queryForObject("member.loginCheck", id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO loginUser = null;
		loginUser = (MemberVO) smc.queryForObject("member.getMember", id);
		return loginUser;
	}
	
	@Override
	public void updateMember(MemberVO member) {
		try {
			smc.update("member.updateMember", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
