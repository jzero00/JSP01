package com.jsp.request;

import com.jsp.dto.MemberVO;

public class MemberModifyRequest {
	
	private String id;
	private String pwd;
	private String email;
	private String[] phone;
	private String picture;
	private String name;
	private String address;
	
	public MemberModifyRequest() {}
	public MemberModifyRequest(String id, String pwd, String email, String[] phone, String picture,
			String name, String address) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.picture = picture;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getPhone() {
		return phone;
	}
	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MemberVO toMemberVO() {				
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setPicture(picture);
		member.setPhone(phone[0]+phone[1]+phone[2]);
		member.setName(name);
		member.setAddress(address);
		
		return member;
	}	
}



