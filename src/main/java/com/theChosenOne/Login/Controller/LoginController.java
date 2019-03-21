package com.theChosenOne.Login.Controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.Job.Entity.JobEntity;
import com.theChosenOne.Login.Util.CodeUtil;
import com.theChosenOne.Majoy.Entity.MajoyEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;
import com.theChosenOne.Util.MD5Utils;

@Controller
@RequestMapping(value ="/Login")
public class LoginController {
	
	@Resource
	private UserServices services;
	
	@RequestMapping(value ="/getCode")
	public void getCode(HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String,Object> codePic = CodeUtil.generateCodeAndPic();
		HttpSession session = request.getSession();
		session.setAttribute("code", codePic.get("code"));
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		response.setContentType("image/jpeg");

	       
	        ServletOutputStream sos;
	        try {
	            sos = response.getOutputStream();
	            ImageIO.write((RenderedImage) codePic.get("codePic"), "jpeg", sos);
	            sos.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	@ResponseBody
	@RequestMapping("/checkCode")
	public boolean checkCode(String code,HttpServletRequest request, HttpServletResponse response, Model model) {
		boolean flag = false;
		HttpSession session = request.getSession();
		String codes = session.getAttribute("code").toString();
		if(codes.equals(code)) {
			flag = true;
		}
		return flag;
	}
	
	@RequestMapping(value="/toLogin")
	/**
	 * 登出
	 * @param model
	 * @return
	 */
	public String toRegister(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/logOut")
	public String logOut(HttpServletRequest request, HttpServletResponse response,Model model) {
		request.getSession().invalidate();
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String pwd = request.getParameter("password");
		UserEntity user = null;
		if(!StringUtils.isNullOrEmpty(pwd)) {
			user = services.login(account, MD5Utils.MD5Encrypt64(pwd));
		}
		if(user == null) {  
			model.addAttribute("loginMessage", "账号密码错误，请检查后重新输入!");
			return "login";
		} else {
			String type = user.getType();
			if("0".equals(type)) {
				session.setAttribute("Admin", "admin");
				session.setAttribute("user", user);
				return "redirect:/Admin/toAdmin";
			} else {
				String status = user.getStatus();
				if("1".equals(status)) {
					session.setAttribute("user", user);
					if("1".equals(type)) {
						session.setAttribute("userType", "stu");
					} else {
						session.setAttribute("userType", "com");
					}
					return "redirect:/User/toUserPage";
				} else {
					model.addAttribute("loginMessage", "该账号暂时无法登陆，请与管理员确认");
					return "login";
				}
			}
		}
	}
}
