package com.theChosenOne.Majoy.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.theChosenOne.Majoy.Entity.MajoyEntity;

@Repository
public interface MajoyDao  {
	
	public List<MajoyEntity> findAll();
	
	public int addMajoy(MajoyEntity c);
	
	public int modifyMajoy(MajoyEntity c);
	
	public int delMajoy(String id);
	
	public int findByName(String name);
	
	public List<String> returnMajoysList();
	
}
