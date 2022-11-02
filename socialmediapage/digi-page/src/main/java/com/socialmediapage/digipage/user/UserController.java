package com.socialmediapage.digipage.user;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.socialmediapage.digipage.friends.*;
import com.socialmediapage.digipage.posts.*;

@RestController
@Component
public class UserController {
 User user;
@Autowired
private UserService userservice;

@Autowired 
private PostService postservice;

@Autowired
private FriendService friendservice;

public static String directory="D:\\socialmediapage\\digi-page\\src\\main\\resources\\static\\images";

@RequestMapping("/")
public ModelAndView index() 
{
	ModelAndView mv= new ModelAndView("index.jsp");
	return mv; 
}
@PostMapping("/register")
public ModelAndView  value1(HttpServletRequest request,ModelMap map) throws ParseException {
   String redirect="";
   User user= userservice.getData(request.getParameter("email"));
   if(user==null)
   {
	   userservice.insert(request);
	   redirect="login.jsp";
   }
   else {
	   map.put("error1","email is aleady used please use another email");
   }
   ModelAndView mv= new ModelAndView(redirect);
   
   return mv;

}
ModelMap map;
@PostMapping("/login")
public ModelAndView login(HttpServletRequest request,ModelMap modelmap) throws UnsupportedEncodingException {
	
	String redirect;	
	
	if(userservice.login(request,modelmap))
	{
		redirect="homepage.jsp";
		String email=request.getParameter("email");
		user=userservice.getData(email);
		modelmap.put("name",user.getEmail());
		List<Post> postlist= postservice.getallposts();
		modelmap.put("result", postlist);
	}
	else {
		redirect="login.jsp";
		modelmap.put("error", "please give valid information");
	}
	ModelAndView mv= new ModelAndView(redirect);
	return mv;
}


@RequestMapping(value="/profile", method=RequestMethod.GET)
public ModelAndView profile(ModelMap map,@RequestParam String name) throws UnsupportedEncodingException
{
	User user=userservice.getData(name);
	List<Post> post= postservice.userpost(user.getFirstname());
	map.put("postlist",post);
	
	List<Friend> listdata=new ArrayList<>();
	listdata= friendservice.getlist(user.getId());
	List<User> friendlist=new ArrayList<>();
	
	for(Friend x:listdata)
	{
		 User user1= userservice.getbyid(x.getReciever());
		 friendlist.add(user1);
	}
	 map.put("user", user);
	 map.put("friendlist", friendlist);
	  ModelAndView mv= new ModelAndView("userprofile.jsp");
	  
	  return mv;
}

// to add posts
@PostMapping("/addpost")
public ModelAndView addpost(HttpServletRequest request,@RequestParam("image_url") MultipartFile file,ModelMap map) throws UnsupportedEncodingException
{
    postservice.savePost(request,file,directory);
	ModelAndView mv= new ModelAndView("userprofile.jsp");
	//System.out.println(post_list);
	map.put("user", user);
	 String name= user.getFirstname();
	 List<Post> post= postservice.userpost(name);
	 map.put("postlist",post);
	System.out.println("data added");
	
	return mv;
}
// to search friend

@RequestMapping(value="/searchfriend", method=RequestMethod.POST)
public ModelAndView searchfriend(ModelMap map,@RequestParam String name,HttpServletRequest request) throws UnsupportedEncodingException
{
	String friendname=request.getParameter("friendname");
	 List<Post> post= postservice.userpost(name);
	 map.put("postlist",post);
	 User user= userservice.getdatabyname(name);
	User frienddata=userservice.getdatabyname(friendname);
	map.put("friend_data", frienddata);
	    List<Friend> listdata=new ArrayList<>();
		listdata= friendservice.getlist(user.getId());
		List<User> friendlist=new ArrayList<>();
		
		for(Friend x:listdata)
		{
			 User user1= userservice.getbyid(x.getReciever());
			 System.out.println(x.getReciever());
			 friendlist.add(user1);
		}
		 map.put("user", user);
		 map.put("friendlist", friendlist);
	  ModelAndView mv= new ModelAndView("userprofile.jsp");
	  return mv;
}
// friend request

@RequestMapping(value="/addfriend", method=RequestMethod.GET)
public ModelAndView profile(ModelMap map,@RequestParam String uname,@RequestParam int friendid) throws UnsupportedEncodingException
{
	 User user= userservice.getdatabyname(uname);
	 friendservice.savefriend(user.getId(), friendid);
	 List<Post> post= postservice.userpost(uname);
	 map.put("postlist",post);
	 List<Friend> listdata=new ArrayList<>();
		listdata= friendservice.getlist(user.getId());
		List<User> friendlist=new ArrayList<>();
		
		for(Friend x:listdata)
		{
			 User user1= userservice.getbyid(x.getReciever());
			 friendlist.add(user1);
		}
		 map.put("user", user);
		 map.put("friendlist", friendlist);
	 ModelAndView mv= new ModelAndView("userprofile.jsp");
	 return mv;
}

//post deleting by user
@RequestMapping(value="/deletepost", method=RequestMethod.GET)
public ModelAndView deletepost(ModelMap map,@RequestParam String uname,@RequestParam int id) throws UnsupportedEncodingException
{
	ModelAndView mv= new ModelAndView("userprofile.jsp");
	 User user= userservice.getdatabyname(uname);
	postservice.deletepost(id);
	 List<Post> post= postservice.userpost(uname);
	 map.put("postlist",post);
	 List<Friend> listdata=new ArrayList<>();
		listdata= friendservice.getlist(user.getId());
		List<User> friendlist=new ArrayList<>();
		
		for(Friend x:listdata)
		{
			 User user1= userservice.getbyid(x.getReciever());
			 friendlist.add(user1);
		}
		 map.put("user", user);
		 map.put("friendlist", friendlist);

	return mv;
}

@RequestMapping(value="/completeDetails", method=RequestMethod.GET)
public ModelAndView viewfrienddata(ModelMap map,@RequestParam String name,@RequestParam String uname)
{
	ModelAndView mv= new ModelAndView("frienddata.jsp");
	User user=userservice.getdatabyname(name);
	map.put("friend_data", user);
	map.put("name", uname);
	return mv;
	
}

@PostMapping("/updateuser")
public ModelAndView updatedetails(HttpServletRequest request,ModelMap map) throws ParseException
{
	userservice.updateUser(request);
	 User user= userservice.getdatabyname(request.getParameter("firstname"));
	List<Friend> listdata=new ArrayList<>();
	listdata= friendservice.getlist(user.getId());
	List<User> friendlist=new ArrayList<>();
	
	for(Friend x:listdata)
	{
		 User user1= userservice.getbyid(x.getReciever());
		 friendlist.add(user1);
	}
	 map.put("user", user);
	 map.put("friendlist", friendlist);
	  ModelAndView mv= new ModelAndView("userprofile.jsp");
	return mv;
}



}