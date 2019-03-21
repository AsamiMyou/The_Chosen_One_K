package com.theChosenOne.City.Services;

import java.util.List;

import com.theChosenOne.City.Entity.CityEntity;

public interface CityServices {
	public int addCity(CityEntity c);
	
	public List<CityEntity> returnCityList();
	
	public List<String> returnCitysList();
}
