package com.theChosenOne.Message.Services;

import java.util.List;

import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.Job.Entity.JobEntity;
import com.theChosenOne.Message.Entity.MessageEntity;

public interface MessageServices {

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
