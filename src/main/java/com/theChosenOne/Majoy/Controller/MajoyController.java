package com.theChosenOne.Majoy.Controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theChosenOne.Majoy.Entity.MajoyEntity;
import com.theChosenOne.Majoy.Services.MajoyServices;
import com.theChosenOne.Util.JsonUtils;

@Controller
@RequestMapping(value ="/Job")
public class MajoyController {
	
	@Resource
	private MajoyServices MajoyServices;
	
	@RequestMapping(value ="/addMajoy", method=RequestMethod.POST)
	public void addMajoy(@ModelAttribute MajoyEntity Majoy) {
		Majoy.setCreateTime(new Date());
		Majoy.setDelFlag("0");
		MajoyServices.addMajoy(Majoy);
	}
	
	@ResponseBody
	@RequestMapping(value ="/returnMajoyList",produces="text/html;charset=UTF-8")
	public String returnMajoylist(){
		List<MajoyEntity> MajoyList = MajoyServices.returnMajoyList();
		return JsonUtils.returnTableVo(MajoyList);
	}
	
}
