package com.theChosenOne.User.Entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	//ID
	private String id ;
	//账号U_ACCOUNT
	private String account;
	//密码U_PASSWORD
	private String password;
	//联系电话U_PHONE
	private String phone;
	//邮箱U_EMAIL
	private String email;
	//用户类型U_TYPE 0  管理员   1 学生 2 企业
	private String type;
	//创建时间U_CREATETIME
	private Date createTime;
	//是否删除U_DELFLAG 0 未删除 1 已删除
	private String delFlag;
	//账号状态U_STATUS 0 待审额  1 正常使用 2 已禁用
	private String status;
	//头像
	private String avatar;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
