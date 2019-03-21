package com.theChosenOne.Job.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.theChosenOne.Job.Entity.JobEntity;

@Repository
public interface JobDao  {
	
	public List<JobEntity> findAll();
	
	public int addJob(JobEntity c);
	
	public int modifyJob(JobEntity c);
	
	public int delJob(String id);

	public int findByName(String name);
	
	public List<String> returnJobsList();
}
