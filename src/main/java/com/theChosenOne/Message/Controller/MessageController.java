package com.theChosenOne.Message.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theChosenOne.Message.Bean.MessageBean;
import com.theChosenOne.Message.Entity.MessageEntity;
import com.theChosenOne.Message.Services.MessageServices;
import com.theChosenOne.User.Bean.ComBean;
import com.theChosenOne.User.Bean.StudentBean;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;
import com.theChosenOne.Util.JsonUtils;

@Controller
@RequestMapping(value ="/Message")
public class MessageController {

	@Resource
	private MessageServices mservices;
	@Resource
	private UserServices uservices;

	@RequestMapping(value="/toMessage")
	public String toMessage(Model model) {
		return "addEditor";
	}


	@RequestMapping(value="/addMessage",method=RequestMethod.POST)
	public String addMessage(Model model,HttpServletRequest request, HttpServletResponse response) {
		MessageEntity message = new MessageEntity();
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		String type = user.getType();
		String uname = "";
		if("1".equals(type)) {
			uname = uservices.findStudent(user.getId()).getSname();
		} else {
			uname = uservices.findComPany(user.getId()).getCname();
		}
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		message.setContent(content);
		message.setCreator(uname);
		message.setMessageType(type);
		message.setTitle(title);
		message.setUserId(user.getId());
		mservices.addMessage(message);
		return "editorSuccess";
	}

	@ResponseBody
	@RequestMapping(value ="/returnStuMessage",produces="text/html;charset=UTF-8")
	public String returnStuMessage(HttpServletRequest request, HttpServletResponse response){
		List<MessageEntity> messList = mservices.findMessageByType("1");
		return JsonUtils.returnTableVo(returnBeanList(messList));
	}

	@ResponseBody
	@RequestMapping(value ="/returnComMessage",produces="text/html;charset=UTF-8")
	public String returnComMessage(HttpServletRequest request, HttpServletResponse response){
		List<MessageEntity> messList = mservices.findMessageByType("2");
		return JsonUtils.returnTableVo(returnBeanList(messList));
	}

	@ResponseBody
	@RequestMapping(value ="/returnAllMessage",produces="text/html;charset=UTF-8")
	public String returnAllMessage(HttpServletRequest request, HttpServletResponse response){
		List<MessageEntity> messList = mservices.findAllMessage();
		return JsonUtils.returnTableVo(returnBeanList(messList));
	}

	@RequestMapping(value ="/toCreatorMessage")
	public String toCreatorMessage(HttpServletRequest request, HttpServletResponse response,Model model){
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		String type = user.getType();
		switch(type) {
		case "1" :
			StudentBean stu = returnStuBean(uservices.findStudent(user.getId()));
			model.addAttribute("userBean", stu);
			break;
		case "2" :
			ComBean com = returnComBean(uservices.findComPany(user.getId()));
			model.addAttribute("userBean", com);
			break;
		}
		model.addAttribute("messageType", type);
		return "creatorEditor";
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/returnCreatorMessage",produces="text/html;charset=UTF-8")
	public String returnCreatorMessage(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<MessageEntity> messList = mservices.findMessageByCreator(user.getId());
		return JsonUtils.returnTableVo(returnBeanList(messList));
	}
	
	@ResponseBody
	@RequestMapping(value ="/returnUserMessage",produces="text/html;charset=UTF-8")
	public String returnUserMessage(HttpServletRequest request, HttpServletResponse response){
		String uid = request.getParameter("uid");
		List<MessageEntity> messList = mservices.findMessageByUid(uid);
		return JsonUtils.returnTableVo(returnBeanList(messList));
	}
	

	@RequestMapping(value ="/modifyMessage")
	public String modifyMessage(HttpServletRequest request, HttpServletResponse response){
		MessageEntity message = new MessageEntity();
		String content = request.getParameter("content");
		String mid = request.getParameter("mid");
		message.setId(mid);
		message.setContent(content);
		mservices.modifyMessage(message);
		return "editorSuccess";
	}

	@ResponseBody
	@RequestMapping(value ="/delMessage")
	public boolean delMessage(HttpServletRequest request, HttpServletResponse response){
		boolean flag = false;
		String mid = request.getParameter("mid");
		if(mservices.delMessage(mid) > 0) {
			flag = true;
		}
		return flag;
	}

	@ResponseBody
	@RequestMapping(value ="/passMessage")
	public boolean passMessage(HttpServletRequest request, HttpServletResponse response){
		boolean flag = false;
		String mid = request.getParameter("mid");
		if(mservices.passMessage(mid) > 0) {
			flag = true;
		}
		return flag;
	}

	@ResponseBody
	@RequestMapping(value ="/refuseMessage")
	public boolean refuseMessage(HttpServletRequest request, HttpServletResponse response){
		boolean flag = false;
		String mid = request.getParameter("mid");
		if(mservices.refuseMessage(mid) > 0) {
			flag = true;
		}
		return flag;
	}

	@RequestMapping(value ="/toEditMessage")
	public String toEditMessage(HttpServletRequest request, HttpServletResponse response,Model model){
		String mid = request.getParameter("mid");
		MessageEntity message = mservices.findMessageById(mid);
		model.addAttribute("message", message);
		mservices.addSeeTime(mid);
		return "editEditor";
	}

	@RequestMapping(value ="/toSeeMessage")
	public String toSeeMessage(HttpServletRequest request, HttpServletResponse response,Model model){
		String mid = request.getParameter("mid");
		MessageEntity message = mservices.findMessageById(mid);
		String type = message.getMessageType();
		switch(type) {
		case "1" :
			StudentBean stu = returnStuBean(uservices.findStudent(message.getUserId()));
			model.addAttribute("userBean", stu);
			break;
		case "2" :
			ComBean com = returnComBean(uservices.findComPany(message.getUserId()));
			model.addAttribute("userBean", com);
			break;
		}
		model.addAttribute("message", message);
		mservices.addSeeTime(mid);
		return "seeEditor";
	}

	private StudentBean returnStuBean(StudentEntity stu) {
		StudentBean tempbean = new StudentBean();
		UserEntity tempUser = uservices.findUserById(stu.getUserId());
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
		UserEntity tempUser = uservices.findUserById(com.getUserId());
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
	
	private List<MessageBean> returnBeanList(List<MessageEntity> entitylist) {
		List<MessageBean> beanList = new ArrayList<MessageBean>();
		for (MessageEntity tempEntity : entitylist) {
			MessageBean tempbean = new MessageBean();
			tempbean.setCreator(tempEntity.getCreator());
			tempbean.setId(tempEntity.getId());
			tempbean.setMessageType(tempEntity.getMessageType());
			tempbean.setSeeTime(tempEntity.getSeeTime());
			tempbean.setStatus(tempEntity.getStatus());
			tempbean.setTitle(tempEntity.getTitle());
			tempbean.setUserId(tempEntity.getUserId());
			tempbean.setCreateTime(tempEntity.getCreateTime());
			beanList.add(tempbean);
		}
		return beanList;
	}

}
