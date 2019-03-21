/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.theChosenOne.City.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.theChosenOne.City.Entity.CityEntity;

@Repository
public interface CityDao  {
	
	public List<CityEntity> findAll();
	
	public int addCity(CityEntity c);
	
	public int modifyCity(CityEntity c);
	
	public int delCity(String id);

	public int findByName(String name);
	
	public List<String> returnCitysList();
	
}
