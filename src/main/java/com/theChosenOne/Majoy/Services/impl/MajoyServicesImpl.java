package com.theChosenOne.Majoy.Services.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.Majoy.Dao.MajoyDao;
import com.theChosenOne.Majoy.Entity.MajoyEntity;
import com.theChosenOne.Majoy.Services.MajoyServices;
import com.theChosenOne.Util.IdUtils;

@Service
public class MajoyServicesImpl implements MajoyServices {

	@Resource
	private MajoyDao dao;
	
	@Override
	public int addMajoy(MajoyEntity c) {
		if(StringUtils.isNullOrEmpty(c.getId())) {
			c.setId(IdUtils.getUUID());
		}
		c.setCreateTime(new Date());
		c.setDelFlag("0");
		return dao.addMajoy(c);
	}

	@Override
	public List<MajoyEntity> returnMajoyList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<String> returnMajoysList() {
		// TODO Auto-generated method stub
		return dao.returnMajoysList();
	}

	
}
