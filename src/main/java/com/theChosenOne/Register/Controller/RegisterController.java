package com.theChosenOne.Register.Controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mysql.jdbc.StringUtils;
import com.theChosenOne.City.Entity.CityEntity;
import com.theChosenOne.City.Services.CityServices;
import com.theChosenOne.Job.Entity.JobEntity;
import com.theChosenOne.Job.Services.JobServices;
import com.theChosenOne.Majoy.Entity.MajoyEntity;
import com.theChosenOne.Majoy.Services.MajoyServices;
import com.theChosenOne.User.Entity.ComEntity;
import com.theChosenOne.User.Entity.StudentEntity;
import com.theChosenOne.User.Entity.UserEntity;
import com.theChosenOne.User.Services.UserServices;

@Controller
@RequestMapping(value="/register")
/**
 * 
 * @author Asami Myou
 * @Date 2018年4月12日
 * @Describe 注册控制类
 * @package com.theChosenOne.Register.Controller
 */
public class RegisterController {

	@Resource
	private UserServices uservices;
	@Resource
	private JobServices jservices;
	@Resource
	private MajoyServices mservices;
	@Resource
	private CityServices cservices;

	@RequestMapping(value="/toRegister")
	public String toRegister(Model model) {
		List<CityEntity> cityls = cservices.returnCityList();
		List<JobEntity> jobls = jservices.returnJobList();
		List<MajoyEntity> majoyls = mservices.returnMajoyList();
		model.addAttribute("citys", cityls);
		model.addAttribute("jobs", jobls);
		model.addAttribute("majoys", majoyls);
		return "register";
	}
	
	@Transactional
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@ModelAttribute UserEntity user,HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		String type = user.getType();
		user.setType(type);
		uservices.addUser(user);
		List fileTypes = new ArrayList<String>();  
		fileTypes.add("jpg");  
		fileTypes.add("jpeg");  
		fileTypes.add("bmp");  
		fileTypes.add("png");  
		String fileName = "";
		Long id = null;  
		switch(type) {
		case "1" ://学生
			StudentEntity student = new StudentEntity();
			String sname = request.getParameter("sname");
			String sex = request.getParameter("sex");
			String sbirthday = request.getParameter("birthday");
			Date birthday = null;
			try {
				birthday = StringUtils.isNullOrEmpty(sbirthday) ? null : sdf.parse(sbirthday);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<String> cityls = cservices.returnCitysList();
			List<String> jobls = jservices.returnJobsList();
			List<String> majoyls = mservices.returnMajoysList();
			String studentId = request.getParameter("studentId");
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
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
			MultipartFile img = multipartRequest.getFile("simgUrl");  //获取图片
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
					student.setSimgUrl(picPath);
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
			student.setBirthday(birthday);
			student.setCity(city);
			student.setCreateTime(new Date());
			student.setJob(job);
			student.setLevel(level);
			student.setMajoy(majoy);
			student.setSex(sex);
			student.setSmoney(smoney);
			student.setSname(sname);
			student.setStudentId(studentId);
			student.setUserId(user.getId());
			student.setStatus(status);
			uservices.addStudent(student);
			break;
		case "2" ://企业
			ComEntity com = new ComEntity();
			String cname = request.getParameter("cname");
			String person = request.getParameter("person");
			String personId = request.getParameter("personId");
			String cmoney = request.getParameter("cmoney");
			String address = request.getParameter("address");
			String bankAddress = request.getParameter("bankAddress");
			String bankAcoount = request.getParameter("bankAcoount");
			String comNum = request.getParameter("comNum");
			String scomDate = request.getParameter("comDate");
			String mainBussiness = request.getParameter("mainBussiness");
			Date comDate = null;
			try {
				comDate = StringUtils.isNullOrEmpty(scomDate) ? null : sdf.parse(scomDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MultipartHttpServletRequest cmultipartRequest = (MultipartHttpServletRequest) request;  
			MultipartFile cimg = cmultipartRequest.getFile("cimgUrl");  //获取图片
			fileName = cimg.getOriginalFilename();  
			if(!(fileName==null ||"".equals(fileName))){//上传了文件  
				String extensionName = fileName.substring(fileName.lastIndexOf(".")+1);  
				if(fileTypes.contains(extensionName.toLowerCase())){  
					//扩展名合法  
					id = System.currentTimeMillis(); 
					String root = request.getRealPath("/attach");//图片要上传到的服务器路径
					String newName = id + "." + extensionName;
					String picPath = "/attach/" + newName;
					File newFile = new File(root + "/" + newName);  
					com.setCimgUrl(picPath);
	                // 将内存中的数据写入磁盘  
					try {
						cimg.transferTo(newFile);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}  
			}else{  
				
			}  
			com.setAddress(address);
			com.setBankAcoount(bankAcoount);
			com.setBankAddress(bankAddress);
			com.setCname(cname);
			com.setComDate(comDate);
			com.setComNum(comNum);
			com.setCreateTime(new Date());
			com.setDelFlag("0");
			com.setPerson(person);
			com.setPersonId(personId);
			com.setUserId(user.getId());
			com.setCmoney(Double.valueOf(cmoney));
			com.setMainBussiness(mainBussiness);
			uservices.addComPany(com);
			break;
		}
		return "success";
	}
}
