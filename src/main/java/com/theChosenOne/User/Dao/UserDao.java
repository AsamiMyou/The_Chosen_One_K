/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.theChosenOne.User.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.User.Bean.ComVo;
import com.theChosenOne.User.Bean.StuVo;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;

@Repository
public interface UserDao  {
	
	public int addAvatar(String id,String avatar);
	
	public int changePassword(String id,String oldPassword,String newPassword);
	
	public int rebuildPassword(String id,String password);
	
	public int startUser(String id);
	
	public int stopUser(String id);
	
	public UserEntity login(String account,String pwd);
	
	public List<UserEntity> findAllApprove();
	
	public List<UserEntity> findAllUser();
	
	public List<StudentEntity> findAllStu();
	
	public List<ComEntity> findAllCom();
	
	public UserEntity findUserById(String id);
	
	public int addUser(UserEntity u);
	
	public int modifyUser(UserEntity u);
	
	public int delUser(String id);

	public int addStudent(StudentEntity s);
	
	public StudentEntity findStudent(String uid);
	
	public StudentEntity findStudentById(String id);
	
	public int delStudent(String id);
	
	public int addComPany(ComEntity c);
	
	public ComEntity findComPany(String uid);
	
	public ComEntity findComPanyById(String id);
	
	public int delComPany(String id);
	
	public int modifyStudent(StudentEntity s);
	
	public int modifyCom(ComEntity c);
	
	public List<StudentEntity> findStuByKey(@Param("keyword")String keyword);
	
	public List<ComEntity> findComByKey(@Param("keyword")String keyword);
	
	public List<StudentEntity> findTopStu();
	
	public List<ComEntity> findTopCom();
	
	public List<StudentEntity> findStuByVo(StuVo vo);
	
	public List<ComEntity> findComByVo(ComVo vo);
}
