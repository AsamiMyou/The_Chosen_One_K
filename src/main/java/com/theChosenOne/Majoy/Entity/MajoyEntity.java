package com.theChosenOne.Majoy.Entity;

import java.io.Serializable;
import java.util.Date;

public class MajoyEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	//id
	private String id;
	//城市名称
	private String majoyName;
	//创建时间
	private Date createTime;
	//是否删除 0 未删除  1删除
	private String delFlag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getMajoyName() {
		return majoyName;
	}
	public void setMajoyName(String majoyName) {
		this.majoyName = majoyName;
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
	
	public MajoyEntity(String id, String majoyName, Date createTime, String delFlag) {
		this.id = id;
		this.majoyName = majoyName;
		this.createTime = createTime;
		this.delFlag = delFlag;
	}
	
	
	public MajoyEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public MajoyEntity(String name) {
		this.majoyName = name;
	}
}
