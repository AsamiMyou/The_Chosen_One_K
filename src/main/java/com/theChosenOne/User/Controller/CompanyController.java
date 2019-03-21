package com.theChosenOne.User.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.City.Services.CityServices;
import com.theChosenOne.Job.Services.JobServices;
import com.theChosenOne.Majoy.Services.MajoyServices;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;

@Controller
@RequestMapping(value ="/Com")
public class CompanyController {
	
	@Resource
	private UserServices userServices;
	
	@Resource
	private JobServices jservices;
	@Resource
	private MajoyServices mservices;
	@Resource
	private CityServices cservices;
	
	@RequestMapping(value ="/seeCompany")
	public String seeStudent(@RequestParam("id") String id ,HttpServletRequest request, HttpServletResponse response,Model model) {
		ComEntity company = userServices.findComPany(id);
		UserEntity cuser = userServices.findUserById(id);
		String account = cuser.getAccount();
		model.addAttribute("com", company);
		model.addAttribute("cuser", cuser);
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		if(user.getAccount().equals(account)) {
			model.addAttribute("creator", "creator");
		}
		return "comInfo";
	}
	
	@Transactional
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String Edit(@ModelAttribute UserEntity user,HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		ComEntity com = new ComEntity();
		String person = request.getParameter("person");
		String personId = request.getParameter("personId");
		String cmoney = request.getParameter("cmoney");
		String address = request.getParameter("address");
		String bankAddress = request.getParameter("bankAddress");
		String bankAcoount = request.getParameter("bankAcoount");
		String comNum = request.getParameter("comNum");
		String mainBussiness = request.getParameter("mainBussiness");
		String scomDate = request.getParameter("comDate");
		Date comDate = null;
		try {
			comDate = StringUtils.isNullOrEmpty(scomDate) ? null : sdf.parse(scomDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		com.setAddress(address);
		com.setBankAcoount(bankAcoount);
		com.setBankAddress(bankAddress);
		com.setComDate(comDate);
		com.setComNum(comNum);
		com.setCreateTime(new Date());
		com.setDelFlag("0");
		com.setPerson(person);
		com.setPersonId(personId);
		com.setUserId(user.getId());
		com.setCmoney(Double.valueOf(cmoney));
		com.setMainBussiness(mainBussiness);
		userServices.modifyUser(user);
		userServices.modifyCom(com);
		return "redirect:/Com/seeCompany?id=" + user.getId();
	}
	
	
}
