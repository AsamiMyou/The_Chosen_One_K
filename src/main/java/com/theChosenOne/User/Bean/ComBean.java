package com.theChosenOne.User.Bean;

import java.util.Date;

public class ComBean {
	//公司地址
	private String address;
	//营业执照到期时间
	private Date comDate;
	//创建时间
	private Date createTime;
	
	//用户ID
	private String userId;
	//公司名称
	private String cname;
	//联系电话U_PHONE
	private String phone;
	//邮箱U_EMAIL
	private String email;
	//头像
	private String avatar;
	
	//主营业务
	private String mainBussiness;
	
	
	public String getMainBussiness() {
		return mainBussiness;
	}
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
