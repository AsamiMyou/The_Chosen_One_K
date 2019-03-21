package com.theChosenOne.Job.Controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.City.Services.CityServices;
import com.theChosenOne.Util.JsonUtils;

@Controller
@RequestMapping(value ="/Job")
public class JobController {
	
	@Resource
	private CityServices cityServices;
	
	@RequestMapping(value ="/addCity", method=RequestMethod.POST)
	public void addCity(@ModelAttribute CityEntity city) {
		city.setCreateTime(new Date());
		city.setDelFlag("0");
		cityServices.addCity(city);
	}
	
	@ResponseBody
	@RequestMapping(value ="/returnCityList",produces="text/html;charset=UTF-8")
	public String returnCitylist(){
		List<CityEntity> cityList = cityServices.returnCityList();
		return JsonUtils.returnTableVo(cityList);
	}
	
}
