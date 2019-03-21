package com.theChosenOne.City.Services.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.City.Dao.CityDao;
import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.City.Services.CityServices;
import com.theChosenOne.Util.IdUtils;

@Service
public class CityServicesImpl implements CityServices {

	@Resource
	private CityDao dao;
	
	@Override
	public int addCity(CityEntity c) {
		if(StringUtils.isNullOrEmpty(c.getId())) {
			c.setId(IdUtils.getUUID());
		}
		c.setCreateTime(new Date());
		c.setDelFlag("0");
		return dao.addCity(c);
	}

	@Override
	public List<CityEntity> returnCityList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<String> returnCitysList() {
		// TODO Auto-generated method stub
		return dao.returnCitysList();
	}

	
}
