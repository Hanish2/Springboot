package com.socialmediapage.digipage.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialmediapage.digipage.bean.User;
import com.socialmediapage.digipage.repository.UserRepository;
import com.socialmediapage.digipage.service.Userservice;

@Service
public class UserService  implements Userservice{
@Autowired
private UserRepository repository;

@Override
    public void insert(HttpServletRequest request) throws ParseException
    {
    	User user= new User();
    	user.setFirstName(request.getParameter("firstName"));
    	user.setLastName(request.getParameter("lastName"));
    	user.setGender(request.getParameter("gender"));
    	String date=request.getParameter("dateOfBirth");
    	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
    	user.setDateOfBirth(date1);
    	user.setMobile(request.getParameter("mobile"));
    	user.setEmail(request.getParameter("email"));
    	user.setPassword(request.getParameter("password"));
    	this.repository.save(user);
    }
   
@Override
    public boolean login(HttpServletRequest request,ModelMap modelmap) throws NullPointerException
    {
    	User user= new User();
    
    	String email= request.getParameter("email");
    	String password=request.getParameter("password");
    	user= repository.findByemail(email);
    	if(user.getEmail().equals(email)&&user.getPassword().equals(password))
    	{
    		modelmap.put("email", email);
    		return true;
    	}
    	else
    		return false;
    }
    
@Override
    public  User getDataByEmail(String email) throws NullPointerException
    {
       User user=repository.findByemail(email);
    	   return user;
    }

@Override
public void updateUser(HttpServletRequest request) throws ParseException
{
	User user=repository.findById(Integer.parseInt(request.getParameter("id")));
	user.setFirstName(request.getParameter("firstName"));
	user.setLastName(request.getParameter("lastName"));
	user.setGender(request.getParameter("gender"));
	String date=request.getParameter("dateOfBirth");
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
	user.setDateOfBirth(date1);
	user.setMobile(request.getParameter("mobile"));
	user.setEmail(request.getParameter("email"));
	user.setPassword(request.getParameter("password"));
	repository.save(user);
}

@Override
public User getDataByName(String name) throws NullPointerException {
 	return repository.findByfirstName(name);
}

@Override
public User getDataById(int id)  throws NullPointerException {
	
    return repository.findById(id);
}

}

