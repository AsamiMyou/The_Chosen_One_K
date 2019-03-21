package com.theChosenOne.User.Bean;

public class StudentBean {
	//用户ID
	private String userId;
	//用户姓名
	private String sname;
	//联系电话U_PHONE
	private String phone;
	//邮箱U_EMAIL
	private String email;
	
	private String majoy;
	//头像
	private String avatar;
	
	private String sjob;
	
	private String scity;
	
	private String smoney;

	
	
	public String getSjob() {
		return sjob;
	}
	public void setSjob(String sjob) {
		this.sjob = sjob;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSmoney() {
		return smoney;
	}
	public void setSmoney(String smoney) {
		this.smoney = smoney;
	}
	public String getMajoy() {
		return majoy;
	}
	public void setMajoy(String majoy) {
		this.majoy = majoy;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
