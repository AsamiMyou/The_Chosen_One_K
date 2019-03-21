package com.theChosenOne.Job.Services.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.Job.Dao.JobDao;
import com.theChosenOne.Job.Entity.JobEntity;
import com.theChosenOne.Job.Services.JobServices;
import com.theChosenOne.Util.IdUtils;

@Service
public class JobServicesImpl implements JobServices {

	@Resource
	private JobDao dao;
	
	@Override
	public int addJob(JobEntity c) {
		if(StringUtils.isNullOrEmpty(c.getId())) {
			c.setId(IdUtils.getUUID());
		}
		c.setCreateTime(new Date());
		c.setDelFlag("0");
		return dao.addJob(c);
	}

	@Override
	public List<JobEntity> returnJobList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<String> returnJobsList() {
		// TODO Auto-generated method stub
		return dao.returnJobsList();
	}

	
}
