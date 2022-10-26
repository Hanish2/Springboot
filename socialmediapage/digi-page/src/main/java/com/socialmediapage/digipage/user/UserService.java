package com.socialmediapage.digipage.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {
@Autowired
private UserRepository repository;
    public void insert(HttpServletRequest request) throws ParseException
    {
    	User user= new User();
    	user.setFirstname(request.getParameter("firstname"));
    	user.setLastname(request.getParameter("lastname"));
    	user.setGender(request.getParameter("gender"));
    	String date=request.getParameter("dateofbirth");
    	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
    	user.setDateofbirth(date1);
    	user.setMobile(request.getParameter("mobile"));
    	user.setEmail(request.getParameter("email"));
    	user.setPassword(request.getParameter("password"));
    	System.out.println(user.getGender());
    	this.repository.save(user);
    }
   
 
    public boolean login(HttpServletRequest request)
    {
    	User user= new User();
    	String email= request.getParameter("email");
    	String password=request.getParameter("password");
    	user= repository.findByemail(email);
    	ModelMap modelmap = new ModelMap();
    	modelmap.addAttribute("user",user);
    	if(user.getEmail().equals(email)&&user.getPassword().equals(password))
    	{
    		
    		return true;
    	}
    	else
    		return false;
    }
    
    public  User getData(String email)
    {
       User user=repository.findByemail(email);
       System.out.println(user.getFirstname());
    	return user;
    }
   
    
}
