package com.socialmediapage.digipage.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmediapage.digipage.posts.Post;
import com.socialmediapage.digipage.posts.PostRepository;
import com.socialmediapage.digipage.user.User;
import com.socialmediapage.digipage.user.UserRepository;

@Service
public class AdminService {
@Autowired
AdminRepository adminrepo;

@Autowired
UserRepository userrepo;

@Autowired
PostRepository postRepository; 




public void save(HttpServletRequest request)
{
	Admin admin=new Admin();
	admin.setName(request.getParameter("name"));
	admin.setPhoneNumber(request.getParameter("phonenumber"));
	admin.setEmail(request.getParameter("email"));
	admin.setPassword(request.getParameter("password"));
	adminrepo.save(admin);
	System.out.println(admin.getEmail());
	
}

public boolean login(HttpServletRequest request)
{
	Admin admin=adminrepo.findByemail(request.getParameter("email"));
	if(admin!=null)
	{
		if(admin.getPassword().equals(request.getParameter("password"))) {
			return true;
		}
	}
	return false;
}

public void deleteuser(int id)
{
	User user=userrepo.findById(id);
	userrepo.deleteById(id);
  List<Post> list=	postRepository.findAllByuname(user.getFirstname());
	for(Post x:list)
	{
		postRepository.deleteById(x.getPost_id());
	}
	System.out.println(" user data deleted");
	System.out.println("posta made by user deleted");
}

public void deletepost(int id)	
{
	postRepository.deleteById(id);
	System.out.println("post data deleted");
}

public List<User> getalluserlist()
{
	List<User> userList= new ArrayList();
	userrepo.findAll().forEach(x->userList.add(x));
	return userList;
}

public List<Post> getallposts()
{
	List<Post> postList= new ArrayList();
	postRepository.findAll().forEach(x->postList.add(x));
	for(Post x:postList) 
	{
		byte[] imgdata=x.getImage_url();
		if(imgdata!=null)
		{
			String base64EncodedImageBytes = Base64.getEncoder().encodeToString(imgdata);
		    x.setBase64image(base64EncodedImageBytes);
		}
	}
	
	return postList;
}

public void updateUser(HttpServletRequest request) throws ParseException
{
	User user=userrepo.findById(Integer.parseInt(request.getParameter("id")));
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
	userrepo.save(user);
}



}
