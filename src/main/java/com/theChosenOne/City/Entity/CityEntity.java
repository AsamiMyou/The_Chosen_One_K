package com.theChosenOne.City.Entity;

import java.io.Serializable;
import java.util.Date;

public class CityEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	//id
	private String id;
	//城市名称
	private String cityName;
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
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	
	public CityEntity(String id, String cityName, Date createTime, String delFlag) {
		this.id = id;
		this.cityName = cityName;
		this.createTime = createTime;
		this.delFlag = delFlag;
	}
	
	
	public CityEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public CityEntity(String name) {
		this.cityName = name;
	}
}
