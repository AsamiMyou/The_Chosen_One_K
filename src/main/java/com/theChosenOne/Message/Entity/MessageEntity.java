package com.theChosenOne.Message.Entity;

import java.io.Serializable;
import java.util.Date;

public class MessageEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	//id
	private String id;
	//创建人id
	private String userId;
	//创建人姓名
	private String creator;
	//信息标题
	private String title;
	//信息内容
	private String content;
	//信息状态
	private String status;
	//信息查看次数
	private int seeTime;
	//是否删除
	private String delFlag;
	//信息分类 1:学生 2 企业
	private String messageType;
	//创建时间
	private Date createTime;
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSeeTime() {
		return seeTime;
	}
	public void setSeeTime(int seeTime) {
		this.seeTime = seeTime;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
