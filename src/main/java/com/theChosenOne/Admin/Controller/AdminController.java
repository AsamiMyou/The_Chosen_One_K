package com.theChosenOne.Admin.Controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;
import com.theChosenOne.Util.JsonUtils;

@Controller
@RequestMapping(value ="/Admin")
public class AdminController {

	@Resource
	private UserServices userServices;
	
	
	@ResponseBody
	@RequestMapping(value ="/returnApprovesList",produces="text/html;charset=UTF-8")
	public String returnCitylist(){
		List<UserEntity> userList = userServices.findAllApprove();
		return JsonUtils.returnTableVo(userList);
	}
	
	@RequestMapping(value="/toAdmin")
	public String toAdmin(Model model) {
		List<UserEntity> userlt = userServices.findAllUser();
		Map<String, List> userMap = renturnUserListStr(userlt);
		model.addAttribute("userMap", userMap);
		return "admin";
	}
	
	private Map<String, List> renturnUserListStr(List<UserEntity> userlt) {
		Map<String, List> userMap = new HashMap<String, List>();
		List<String> userlst = new ArrayList<String>();
		List<String> comlst = new ArrayList<String>();
		for (int i = 0; i < userlt.size() ; i++) {
			UserEntity tempEntity = userlt.get(i);
			String id = tempEntity.getId();
			String type = tempEntity.getType();// 1 学生  2 企业
			String status = tempEntity.getStatus();// 0 审核中 1正常使用 2已禁用
			String tempstr = "";
			if("1".equals(type)) {//学生
				StudentEntity tempstu = userServices.findStudent(id);
				String sname = tempstu.getSname();
				tempstr += "<a href='/Student/seeStudent?id=" + id + "'>" + sname + "</a>";
				tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
				tempstr += "<a id-data='" + id + "' href='#' class='repass'>" + "重置密码</a>";
				tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
				switch(status) {
					case "0" :
						tempstr += "待审核";
						tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
						break;
					case "1" :
						tempstr += "<a id-data='" + id + "' href='#' class='stop'>" + "停用</a>";
						tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
						break;
					case "2" :
						tempstr += "<a id-data='" + id + "' href='#' class='start'>" + "启用</a>";
						tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
						break;
				}
				tempstr += "<a id-data='" + id + "' href='#' class='del'>删除</a>";
				userlst.add(tempstr);
			} else {
				ComEntity tempcom = userServices.findComPany(id);
				String cname = tempcom.getCname();
				tempstr += "<a href='/Com/seeCompany?id=" + id + "'>" + cname + "</a>";
				tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
				tempstr += "<a id-data='" + id + "' href='#' class='repass'>" + "重置密码</a>";
				tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
				switch(status) {
					case "0" :
						tempstr += "待审核";
						tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
						break;
					case "1" :
						tempstr += "<a id-data='" + id + "' href='#' class='stop'>" + "停用</a>";
						tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
						break;
					case "2" :
						tempstr += "<a id-data='" + id + "' href='#' class='start'>" + "启用</a>";
						tempstr += "&nbsp;&nbsp;&nbsp;&nbsp;";
						break;
				}
				tempstr += "<a id-data='" + id + "' href='#' class='del'>删除</a>";
				comlst.add(tempstr);
			}
		}
		userMap.put("userlst", userlst);
		userMap.put("comlst", comlst);
		return userMap;
	}
	
	@ResponseBody
	@RequestMapping(value ="/start")
	/**
	 * 启动账号
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean start(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("Admin");
		if(admin != null) {
			if(userServices.startUser(id) == 1) {
				flag = true;
			}
		}
		return flag;
	}

	@ResponseBody
	@RequestMapping(value ="/stop")
	/**
	 * 禁用账号
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean stop(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		//验证有没有管理员权限
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("Admin");
		if(admin != null) {
			if(userServices.stopUser(id) == 1) {
				flag = true;
			}
		}
		return flag;
	}

	@ResponseBody
	@RequestMapping(value ="/rebuildPass")
	public boolean rebuildPass(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		//验证有没有管理员权限
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("Admin");
		if(admin != null) {
			if(userServices.rebuildPassword(id) == 1) {
				flag = true;
			}
		}
		return flag;
	}
	
	@ResponseBody
	@RequestMapping(value ="/delUser")
	public boolean delUser(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		//验证有没有管理员权限
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("Admin");
		if(admin != null) {
			if(userServices.delUser(id) == 1) {
				flag = true;
			}
		}
		return flag;
	}
	
}
