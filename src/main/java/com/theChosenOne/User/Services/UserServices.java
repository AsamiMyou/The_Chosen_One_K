package com.theChosenOne.User.Services;

import java.util.List;

import com.theChosenOne.User.Bean.ComVo;
import com.theChosenOne.User.Bean.StuVo;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;

public interface UserServices {
	
	public int addAvatar(String id,String avatar);
	
	public int changePassword(String id,String oldPassword,String newPassword);
	
	public int rebuildPassword(String id);
	
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
	
	public int addComPany(ComEntity c);
	
	public ComEntity findComPany(String uid);
	
	public ComEntity findComPanyById(String id);
	
	public int modifyStudent(StudentEntity s);
	
	public int modifyCom(ComEntity c);
	
	public List<StudentEntity> findStuByKey(String keyword);
	
	public List<ComEntity> findComByKey(String keyword);
	
	public List<StudentEntity> findTopStu();
	
	public List<ComEntity> findTopCom();
	
	public List<StudentEntity> findStuByVo(StuVo vo);
	
	public List<ComEntity> findComByVo(ComVo vo);
}
