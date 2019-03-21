package com.theChosenOne.Job.Services;

import java.util.List;

import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.Job.Entity.JobEntity;

public interface JobServices {
	public int addJob(JobEntity c);
	
	public List<JobEntity> returnJobList();
	
	public List<String> returnJobsList();
}
