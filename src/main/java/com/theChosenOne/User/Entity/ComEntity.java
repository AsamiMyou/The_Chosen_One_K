package com.theChosenOne.User.Entity;

import java.io.Serializable;
import java.util.Date;

public class ComEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	//ID
	private String id ;
	//用户ID
	private String userId;
	//公司名称
	private String cname;
	//公司负责人
	private String person;
	//公司负责人身份证号
	private String personId;
	//注册资金 万元
	private Double cmoney;
	//公司地址
	private String address;
	//开户行地址
	private String bankAddress;
	//开户行账号
	private String bankAcoount;
	//公司营业执照编码
	private String comNum;
	//营业执照到期时间
	private Date comDate;
	//营业执照照片
	private String cimgUrl;
	//创建时间
	private Date createTime;
	//是否删除
	private String delFlag;
	//主营业务
	private String mainBussiness;
	
	
	
	public String getMainBussiness() {
		return mainBussiness;
	}
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getBankAcoount() {
		return bankAcoount;
	}
	public void setBankAcoount(String bankAcoount) {
		this.bankAcoount = bankAcoount;
	}
	public String getComNum() {
		return comNum;
	}
	public void setComNum(String comNum) {
		this.comNum = comNum;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	
	public Double getCmoney() {
		return cmoney;
	}
	public void setCmoney(Double cmoney) {
		this.cmoney = cmoney;
	}
	public String getCimgUrl() {
		return cimgUrl;
	}
	public void setCimgUrl(String cimgUrl) {
		this.cimgUrl = cimgUrl;
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
	
}
