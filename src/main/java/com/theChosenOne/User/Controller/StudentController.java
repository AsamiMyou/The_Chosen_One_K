package com.theChosenOne.User.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.City.Services.CityServices;
import com.theChosenOne.Job.Entity.JobEntity;
import com.theChosenOne.Job.Services.JobServices;
import com.theChosenOne.Majoy.Entity.MajoyEntity;
import com.theChosenOne.Majoy.Services.MajoyServices;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;

@Controller
@RequestMapping(value ="/Student")
public class StudentController {
	
	@Resource
	private UserServices userServices;
	
	@Resource
	private JobServices jservices;
	@Resource
	private MajoyServices mservices;
	@Resource
	private CityServices cservices;
	
	@RequestMapping(value ="/seeStudent")
	public String seeStudent(@RequestParam("id") String id ,HttpServletRequest request, HttpServletResponse response,Model model) {
		StudentEntity student = userServices.findStudent(id);
		UserEntity suser = userServices.findUserById(id);
		String account = suser.getAccount();
		model.addAttribute("student", student);
		model.addAttribute("suser", suser);
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		if(user.getAccount().equals(account)) {
			model.addAttribute("creator", "creator");
			List<CityEntity> cityls = cservices.returnCityList();
			List<JobEntity> jobls = jservices.returnJobList();
			List<MajoyEntity> majoyls = mservices.returnMajoyList();
			model.addAttribute("citys", cityls);
			model.addAttribute("jobs", jobls);
			model.addAttribute("majoys", majoyls);
		}
		return "stuInfo";
	}
	
	@Transactional
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String Edit(@ModelAttribute UserEntity user,HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		String sbirthday = request.getParameter("birthday");
		Date birthday = null;
		try {
			birthday = StringUtils.isNullOrEmpty(sbirthday) ? null : sdf.parse(sbirthday);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		List<String> cityls = cservices.returnCitysList();
		List<String> jobls = jservices.returnJobsList();
		List<String> majoyls = mservices.returnMajoysList();
		StudentEntity student = new StudentEntity();
		String majoy = request.getParameter("majoy");
		String level = request.getParameter("level");
		String status = request.getParameter("sstatus");
		String city = request.getParameter("city");
		String job = request.getParameter("job");
		String smoney = request.getParameter("smoney");
		if(!cityls.contains(city)) {
			cservices.addCity(new CityEntity(city));
		}
		if(!jobls.contains(job)) {
			jservices.addJob(new JobEntity(job));
		}
		if(!majoyls.contains(majoy)) {
			mservices.addMajoy(new MajoyEntity(majoy));
		}
		student.setBirthday(birthday);
		student.setCity(city);
		student.setCreateTime(new Date());
		student.setJob(job);
		student.setLevel(level);
		student.setMajoy(majoy);
		student.setStatus(status);
		student.setSmoney(smoney);
		student.setUserId(user.getId());
		userServices.modifyUser(user);
		userServices.modifyStudent(student);
		return "redirect:/Student/seeStudent?id=" + user.getId();
	}
	
	
}
