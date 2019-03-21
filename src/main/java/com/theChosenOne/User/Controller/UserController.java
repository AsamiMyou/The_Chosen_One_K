package com.theChosenOne.User.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.Message.Entity.MessageEntity;
import com.theChosenOne.User.Bean.ComBean;
import com.theChosenOne.User.Bean.ComVo;
import com.theChosenOne.User.Bean.StuVo;
import com.theChosenOne.User.Bean.StudentBean;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;
import com.theChosenOne.Util.JsonUtils;
import com.theChosenOne.Util.MD5Utils;

@Controller
@RequestMapping(value ="/User")
public class UserController {

	@Resource
	private UserServices userServices;

	@RequestMapping(value="/toUserPage")
	public String toUserPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		String type = user.getType();
		String str = "";
		switch(type) {
		case "1":
			str = "redirect:/Student/seeStudent?id=" + user.getId();
			break;
		case "2":
			str = "redirect:/Com/seeCompany?id=" + user.getId();
			break;
		}
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="/changePass")
	public boolean changePass(@RequestParam("id") String id,@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {
		boolean flag = false;
		if(userServices.changePassword(id, oldPassword, newPassword) > 0) {
			flag = true;
		}
		return flag;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/addAvatar")
	public String addAvatar(HttpServletRequest request, HttpServletResponse response) {
		String flag = "0";
		List fileTypes = new ArrayList<String>();  
		fileTypes.add("jpg");  
		fileTypes.add("jpeg");  
		fileTypes.add("bmp");  
		fileTypes.add("png");  
		String fileName = "";
		Long id = null; 
		String uid = request.getParameter("uid");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		MultipartFile img = multipartRequest.getFile("avatar");  //获取图片
		fileName = img.getOriginalFilename();  
		if(!(fileName==null ||"".equals(fileName))){//上传了文件  
			String extensionName = fileName.substring(fileName.lastIndexOf(".")+1);  
			if(fileTypes.contains(extensionName.toLowerCase())){  
				//扩展名合法  
				id = System.currentTimeMillis(); 
				String root = request.getRealPath("/attach");//图片要上传到的服务器路径
				String newName = id + "." + extensionName;
				String picPath = "/attach/" + newName;
				File newFile = new File(root + "/" + newName);  
				userServices.addAvatar(uid, picPath);
				//student.setSimgUrl(picPath);
                // 将内存中的数据写入磁盘  
				try {
					img.transferTo(newFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}  
		}else{  
		}  
		return flag;
	}
	
	private List<StudentBean> returnStuBean(List<StudentEntity> stuList) {
		List<StudentBean> beanlist = new ArrayList<StudentBean>();
		for (StudentEntity tempEntity : stuList) {
			StudentBean tempbean = new StudentBean();
			UserEntity tempUser = userServices.findUserById(tempEntity.getUserId());
			tempbean.setAvatar(tempUser.getAvatar());
			tempbean.setEmail(tempUser.getEmail());
			tempbean.setPhone(tempUser.getPhone());
			tempbean.setSname(tempEntity.getSname());
			tempbean.setUserId(tempEntity.getUserId());
			tempbean.setMajoy(tempEntity.getMajoy());
			tempbean.setScity(tempEntity.getCity());
			tempbean.setSjob(tempEntity.getJob());
			tempbean.setSmoney(tempEntity.getSmoney());
			beanlist.add(tempbean);
		}
		return beanlist;
	}
	
	private List<ComBean> returnComBean(List<ComEntity> comList) {
		List<ComBean> beanlist = new ArrayList<ComBean>();
		for (ComEntity tempEntity : comList) {
			ComBean tempbean = new ComBean();
			UserEntity tempUser = userServices.findUserById(tempEntity.getUserId());
			tempbean.setAvatar(tempUser.getAvatar());
			tempbean.setEmail(tempUser.getEmail());
			tempbean.setPhone(tempUser.getPhone());
			tempbean.setCname(tempEntity.getCname());
			tempbean.setUserId(tempEntity.getUserId());
			tempbean.setAddress(tempEntity.getAddress());
			tempbean.setCreateTime(tempEntity.getCreateTime());
			tempbean.setComDate(tempEntity.getComDate());
			tempbean.setMainBussiness(tempEntity.getMainBussiness());
			beanlist.add(tempbean);
		}
		return beanlist;
	}
	
	@ResponseBody
	@RequestMapping(value="/getStuCom")
	public Map<String, List> returnStuCom() {
		Map<String, List> maplist = new HashMap<String, List>();
		List<StudentBean> stulist = returnStuBean(userServices.findTopStu());
		List<ComBean> comlist = returnComBean(userServices.findTopCom());
		maplist.put("stulist", stulist);
		maplist.put("comlist", comlist);
		return maplist;
	}
	
	@ResponseBody
	@RequestMapping(value ="/searchStu",produces="text/html;charset=UTF-8")
	public String searchStu(HttpServletRequest request, HttpServletResponse response){
		String sname = request.getParameter("sname");
		String smajoy = request.getParameter("smajoy");
		String sjob = request.getParameter("sjob");
		String scity = request.getParameter("scity");
		String smoney = request.getParameter("smoney");
		StuVo tempVo = new StuVo();
		tempVo.setScity(scity);
		tempVo.setSjob(sjob);
		tempVo.setSmajoy(smajoy);
		tempVo.setSmoney(smoney);
		tempVo.setSname(sname);
		List<StudentEntity> userList = userServices.findStuByVo(tempVo);
		return JsonUtils.returnTableVo(returnStuBean(userList));
	}
	
	@ResponseBody
	@RequestMapping(value ="/searchSKey",produces="text/html;charset=UTF-8")
	public String searchSKey(HttpServletRequest request, HttpServletResponse response){
		String key = request.getParameter("key");
		List<StudentEntity> userList = userServices.findStuByKey(key);
		return JsonUtils.returnTableVo(returnStuBean(userList));
	}
	
	@ResponseBody
	@RequestMapping(value ="/searchCom",produces="text/html;charset=UTF-8")
	public String searchCom(HttpServletRequest request, HttpServletResponse response){
		String cname = request.getParameter("cname");
		String caddress = request.getParameter("caddress");
		String mainBussiness = request.getParameter("mainBussiness");
		ComVo tempVo = new ComVo();
		tempVo.setCaddress(caddress);
		tempVo.setCname(cname);
		tempVo.setMainBussiness(mainBussiness);
		List<ComEntity> comList = userServices.findComByVo(tempVo);
		return JsonUtils.returnTableVo(returnComBean(comList));
	}
	
	@ResponseBody
	@RequestMapping(value ="/searchCKey",produces="text/html;charset=UTF-8")
	public String searchCKey(HttpServletRequest request, HttpServletResponse response){
		String key = request.getParameter("key");
		List<ComEntity> comList = userServices.findComByKey(key);
		return JsonUtils.returnTableVo(returnComBean(comList));
	}
	
	@RequestMapping(value ="/toStu")
	public String toStu(HttpServletRequest request, HttpServletResponse response){
		return "seeSInfo";
	}
	
	@RequestMapping(value ="/toCom")
	public String toCom(HttpServletRequest request, HttpServletResponse response){
		return "seeCInfo";
	}
	
	
	@RequestMapping(value ="/keywordSearch",method=RequestMethod.POST)
	public String keywordSearch(HttpServletRequest request, HttpServletResponse response) {
		String str = "";
		String seaType = request.getParameter("seaType");
		String Search = request.getParameter("Search");
		switch(seaType) {
		case "stu":
			str = "seeSInfo";
			request.setAttribute("Search", Search);
			break;
		case "com":
			str = "seeCInfo";
			request.setAttribute("Search", Search);
			break;
		}
		return str ;
	}
	
	@RequestMapping(value ="/seeUserInfo")
	public String seeUserInfo(HttpServletRequest request, HttpServletResponse responsem, Model model) {
		String uid = request.getParameter("uid");
		UserEntity user = userServices.findUserById(uid);
		String type = user.getType();
		model.addAttribute("messageType", type);
		model.addAttribute("userId", uid);
		switch(type) {
		case "1" :
			StudentBean stu = returnStuBean(userServices.findStudent(uid));
			model.addAttribute("userBean", stu);
			break;
		case "2" :
			ComBean com = returnComBean(userServices.findComPany(uid));
			model.addAttribute("userBean", com);
			break;
		}
		return "userEditor" ;
	}
	
	private StudentBean returnStuBean(StudentEntity stu) {
		StudentBean tempbean = new StudentBean();
		UserEntity tempUser = userServices.findUserById(stu.getUserId());
		tempbean.setAvatar(tempUser.getAvatar());
		tempbean.setEmail(tempUser.getEmail());
		tempbean.setPhone(tempUser.getPhone());
		tempbean.setSname(stu.getSname());
		tempbean.setUserId(stu.getUserId());
		tempbean.setMajoy(stu.getMajoy());
		tempbean.setScity(stu.getCity());
		tempbean.setSjob(stu.getJob());
		tempbean.setSmoney(stu.getSmoney());
		return tempbean;
	}

	private ComBean returnComBean(ComEntity com) {
		ComBean tempbean = new ComBean();
		UserEntity tempUser = userServices.findUserById(com.getUserId());
		tempbean.setAvatar(tempUser.getAvatar());
		tempbean.setEmail(tempUser.getEmail());
		tempbean.setPhone(tempUser.getPhone());
		tempbean.setCname(com.getCname());
		tempbean.setUserId(com.getUserId());
		tempbean.setAddress(com.getAddress());
		tempbean.setCreateTime(com.getCreateTime());
		tempbean.setComDate(com.getComDate());
		tempbean.setMainBussiness(com.getMainBussiness());
		return tempbean;
	}
}
