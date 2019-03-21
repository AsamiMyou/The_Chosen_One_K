package com.theChosenOne.User.Services.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.User.Bean.ComVo;
import com.theChosenOne.User.Bean.StuVo;
import com.theChosenOne.User.Dao.UserDao;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;
import com.theChosenOne.Util.IdUtils;
import com.theChosenOne.Util.MD5Utils;

@Service
@Transactional(readOnly =true)
public class UserServicesimpl implements UserServices{

	@Resource
	private UserDao dao;
	
	
	@Override
	public List<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return dao.findAllUser();
	}

	@Override
	public List<StudentEntity> findAllStu() {
		// TODO Auto-generated method stub
		return dao.findAllStu();
	}

	@Override
	public List<ComEntity> findAllCom() {
		// TODO Auto-generated method stub
		return dao.findAllCom();
	}

	@Override
	@Transactional(readOnly =false, propagation = Propagation.REQUIRES_NEW)
	public int addUser(UserEntity u) {
		// TODO Auto-generated method stub
		if(StringUtils.isNullOrEmpty(u.getId())) {
			u.setId(IdUtils.getUUID());
		}
		u.setCreateTime(new Date());
		u.setDelFlag("0");
		u.setStatus("0");
		//密码加密
		u.setPassword(MD5Utils.MD5Encrypt64(u.getPassword()));
		return dao.addUser(u);
	}

	@Override
	public int modifyUser(UserEntity u) {
		// TODO Auto-generated method stub
		return dao.modifyUser(u);
	}

	@Override
	public int delUser(String id) {
		String type = this.findUserById(id).getType();
		switch(type) {
		case "1"://学生
			dao.delStudent(id);
			break;
		case "2"://企业
			dao.delComPany(id);
			break;
		}
		return dao.delUser(id);
	}

	@Override
	@Transactional(readOnly =false, propagation = Propagation.REQUIRES_NEW)
	public int addStudent(StudentEntity s) {
		// TODO Auto-generated method stub
		if(StringUtils.isNullOrEmpty(s.getId())) {
			s.setId(IdUtils.getUUID());
		}
		s.setDelFlag("0");
		return dao.addStudent(s);
	}

	@Override
	public StudentEntity findStudent(String uid) {
		// TODO Auto-generated method stub
		return dao.findStudent(uid);
	}


	@Override
	@Transactional(readOnly =false, propagation = Propagation.REQUIRES_NEW)
	public int addComPany(ComEntity c) {
		// TODO Auto-generated method stub
		if(StringUtils.isNullOrEmpty(c.getId())) {
			c.setId(IdUtils.getUUID());
		}
		return dao.addComPany(c);
	}

	@Override
	public ComEntity findComPany(String uid) {
		// TODO Auto-generated method stub
		return dao.findComPany(uid);
	}


	@Override
	public List<UserEntity> findAllApprove() {
		// TODO Auto-generated method stub
		return dao.findAllApprove();
	}

	@Override
	public UserEntity login(String account, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(account, pwd);
	}

	@Override
	public StudentEntity findStudentById(String id) {
		// TODO Auto-generated method stub
		return dao.findStudentById(id);
	}

	@Override
	public ComEntity findComPanyById(String id) {
		// TODO Auto-generated method stub
		return dao.findComPanyById(id);
	}

	@Override
	public UserEntity findUserById(String id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}

	@Override
	public int startUser(String id) {
		// TODO Auto-generated method stub
		return dao.startUser(id);
	}

	@Override
	public int stopUser(String id) {
		// TODO Auto-generated method stub
		return dao.stopUser(id);
	}

	@Override
	public int changePassword(String id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return dao.changePassword(id, MD5Utils.MD5Encrypt64(oldPassword), MD5Utils.MD5Encrypt64(newPassword));
	}

	@Override
	public int rebuildPassword(String id) {
		
		String password = MD5Utils.MD5Encrypt64("123456");
		// TODO Auto-generated method stub
		return dao.rebuildPassword(id, password);
	}

	@Override
	public int addAvatar(String id, String avatar) {
		// TODO Auto-generated method stub
		return dao.addAvatar(id, avatar);
	}

	@Override
	public int modifyStudent(StudentEntity s) {
		// TODO Auto-generated method stub
		return dao.modifyStudent(s);
	}

	@Override
	public int modifyCom(ComEntity c) {
		// TODO Auto-generated method stub
		return dao.modifyCom(c);
	}

	@Override
	public List<StudentEntity> findTopStu() {
		// TODO Auto-generated method stub
		return dao.findTopStu();
	}

	@Override
	public List<ComEntity> findTopCom() {
		// TODO Auto-generated method stub
		return dao.findTopCom();
	}

	@Override
	public List<StudentEntity> findStuByKey(String keyword) {
		// TODO Auto-generated method stub
		return dao.findStuByKey(keyword);
	}

	@Override
	public List<ComEntity> findComByKey(String keyword) {
		// TODO Auto-generated method stub
		return dao.findComByKey(keyword);
	}

	@Override
	public List<StudentEntity> findStuByVo(StuVo vo) {
		// TODO Auto-generated method stub
		return dao.findStuByVo(vo);
	}

	@Override
	public List<ComEntity> findComByVo(ComVo vo) {
		// TODO Auto-generated method stub
		return dao.findComByVo(vo);
	}

}
