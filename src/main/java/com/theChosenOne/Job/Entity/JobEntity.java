package com.theChosenOne.Job.Entity;

import java.io.Serializable;
import java.util.Date;

public class JobEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	//id
	private String id;
	//城市名称
	private String jobName;
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
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
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
	
	public JobEntity(String id, String jobName, Date createTime, String delFlag) {
		this.id = id;
		this.jobName = jobName;
		this.createTime = createTime;
		this.delFlag = delFlag;
	}
	
	
	public JobEntity() {
		// TODO Auto-generated constructor stub
	}
	public JobEntity(String name) {
		this.jobName = name;
	}
}
