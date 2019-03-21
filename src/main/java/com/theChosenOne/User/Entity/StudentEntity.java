package com.theChosenOne.User.Entity;

import java.io.Serializable;
import java.util.Date;

public class StudentEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//ID
	private String id ;
	//用户ID
	private String userId;
	//用户姓名
	private String sname;
	//性别
	private String sex;
	//生日
	private Date birthday;
	//学号
	private String studentId;
	//专业
	private String majoy;
	//年级
	private String level;
	//当前状态 0 在读 1 找工作 2 已就业
	private String status;
	//期望工作城市
	private String city;
	//期望工作
	private String job;
	//期望薪资
	private String smoney;
	//图片地址
	private String simgUrl;
	//创建时间
	private Date createTime;
	//是否删除
	private String delFlag;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getMajoy() {
		return majoy;
	}
	public void setMajoy(String majoy) {
		this.majoy = majoy;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getSmoney() {
		return smoney;
	}
	public void setSmoney(String smoney) {
		this.smoney = smoney;
	}
	public String getSimgUrl() {
		return simgUrl;
	}
	public void setSimgUrl(String simgUrl) {
		this.simgUrl = simgUrl;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
}
