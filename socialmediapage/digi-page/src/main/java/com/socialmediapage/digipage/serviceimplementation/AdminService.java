package com.socialmediapage.digipage.serviceimplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmediapage.digipage.entity.Admin;
import com.socialmediapage.digipage.entity.Post;
import com.socialmediapage.digipage.entity.User;
import com.socialmediapage.digipage.interfaces.Adminservice;
import com.socialmediapage.digipage.repository.AdminRepository;
import com.socialmediapage.digipage.repository.PostRepository;
import com.socialmediapage.digipage.repository.UserRepository;

@Service
public class AdminService implements Adminservice {
@Autowired
AdminRepository adminRepository;

@Autowired
UserRepository userRepository;

@Autowired
PostRepository postRepository; 



@Override
public void save(HttpServletRequest request)
{
	Admin admin=new Admin();
	admin.setName(request.getParameter("name"));
	admin.setPhoneNumber(request.getParameter("phoneNumber"));
	admin.setEmail(request.getParameter("email"));
	admin.setPassword(request.getParameter("password"));
	adminRepository.save(admin);
	
}

@Override
public boolean login(HttpServletRequest request)
{
	Admin admin=adminRepository.findByemail(request.getParameter("email"));
	if(admin!=null)
	{
		if(admin.getPassword().equals(request.getParameter("password"))) {
			return true;
		}
	}
	return false;
}

@Override
public void deleteUser(int id) 
{
	User user=userRepository.findById(id);
	userRepository.deleteById(id);
  List<Post> list=	postRepository.findAllByuserName(user.getFirstName());
	for(Post x:list)
	{
		postRepository.deleteById(x.getPost_id());
	}
}

@Override
public void deletePost(int id)	
{
	postRepository.deleteById(id);
	System.out.println("post data deleted");
}



@Override
public List<Post> getAllPosts()
{
	List<Post> postList= new ArrayList();
	postRepository.findAll().forEach(x->postList.add(x));
	for(Post x:postList) 
	{
		byte[] imgData=x.getImage_url();
		if(imgData!=null)
		{
			String base64EncodedImageBytes = Base64.getEncoder().encodeToString(imgData);
		    x.setBase64image(base64EncodedImageBytes);
		}
	}
	
	return postList;

}

@Override
public void updateUser(HttpServletRequest request) throws ParseException
{
	User user=userRepository.findById(Integer.parseInt(request.getParameter("id")));
	user.setFirstName(request.getParameter("firstName"));
	user.setLastName(request.getParameter("lastName"));
	user.setGender(request.getParameter("gender"));
	String date=request.getParameter("dateOfBirth");
	Date formatted_date=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
	user.setDateOfBirth(formatted_date);
	user.setMobile(request.getParameter("mobile"));
	user.setEmail(request.getParameter("email"));
	user.setPassword(request.getParameter("password"));
	System.out.println(user.getGender());
	userRepository.save(user);
}

@Override
public List<User> getAllUserList() {
	List<User> userList= new ArrayList();
	userRepository.findAll().forEach(x->userList.add(x));
	return userList;
}



}
