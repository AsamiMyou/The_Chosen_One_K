package com.theChosenOne.Message.Services.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.Message.Dao.MessageDao;
import com.theChosenOne.Message.Entity.MessageEntity;
import com.theChosenOne.Message.Services.MessageServices;
import com.theChosenOne.Util.IdUtils;

@Service
public class MessageServicesImpl implements MessageServices {

	@Resource
	private MessageDao dao;

	@Override
	public List<MessageEntity> findAllMessage() {
		// TODO Auto-generated method stub
		return dao.findAllMessage();
	}

	@Override
	public List<MessageEntity> findMessageByUid(String uid) {
		// TODO Auto-generated method stub
		return dao.findMessageByUid(uid);
	}

	@Override
	public List<MessageEntity> findMessageByCreator(String uid) {
		// TODO Auto-generated method stub
		return dao.findMessageByCreator(uid);
	}

	@Override
	public List<MessageEntity> findMessageByType(String type) {
		// TODO Auto-generated method stub
		return dao.findMessageByType(type);
	}

	@Override
	public int addMessage(MessageEntity message) {
		if(StringUtils.isNullOrEmpty(message.getId())) {
			message.setId(IdUtils.getUUID());
		}
		message.setCreateTime(new Date());
		message.setDelFlag("0");
		message.setSeeTime(0);
		message.setStatus("0");
		return dao.addMessage(message);
	}

	@Override
	public int modifyMessage(MessageEntity message) {
		// TODO Auto-generated method stub
		return dao.modifyMessage(message);
	}

	@Override
	public int passMessage(String id) {
		// TODO Auto-generated method stub
		return dao.passMessage(id);
	}

	@Override
	public int refuseMessage(String id) {
		// TODO Auto-generated method stub
		return dao.refuseMessage(id);
	}

	@Override
	public int delMessage(String id) {
		// TODO Auto-generated method stub
		return dao.delMessage(id);
	}

	@Override
	public int addSeeTime(String id) {
		// TODO Auto-generated method stub
		return dao.addSeeTime(id);
	}

	@Override
	public MessageEntity findMessageById(String id) {
		// TODO Auto-generated method stub
		return dao.findMessageById(id);
	}
	
	
	
}
