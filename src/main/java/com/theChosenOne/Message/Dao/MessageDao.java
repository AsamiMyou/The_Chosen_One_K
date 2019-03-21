package com.theChosenOne.Message.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.theChosenOne.Message.Entity.MessageEntity;

@Repository
public interface MessageDao  {
	
	public MessageEntity findMessageById(String id);
	
	public List<MessageEntity> findAllMessage();
	
	public List<MessageEntity> findMessageByUid(String uid);
	
	public List<MessageEntity> findMessageByCreator(String uid);
	
	public List<MessageEntity> findMessageByType(String type);
	
	public int addMessage(MessageEntity message);
	
	public int modifyMessage(MessageEntity message);
	
	public int passMessage(String id);
	
	public int refuseMessage(String id);
	
	public int delMessage(String id);
	
	public int addSeeTime(String id);
}
