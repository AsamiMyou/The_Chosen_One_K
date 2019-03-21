package com.theChosenOne.Majoy.Services;

import java.util.List;

import com.theChosenOne.Majoy.Entity.MajoyEntity;

public interface MajoyServices {
	public int addMajoy(MajoyEntity c);
	
	public List<MajoyEntity> returnMajoyList();
	
	public List<String> returnMajoysList();
}
