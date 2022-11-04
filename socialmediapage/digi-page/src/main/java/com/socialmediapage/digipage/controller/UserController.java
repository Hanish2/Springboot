package com.socialmediapage.digipage.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.socialmediapage.digipage.bean.Friend;
import com.socialmediapage.digipage.bean.Post;
import com.socialmediapage.digipage.bean.User;
import com.socialmediapage.digipage.interfaces.Friendservice;
import com.socialmediapage.digipage.interfaces.Postservice;
import com.socialmediapage.digipage.interfaces.Userservice;
import com.socialmediapage.digipage.serviceimplementation.FriendService;
import com.socialmediapage.digipage.serviceimplementation.PostService;
import com.socialmediapage.digipage.serviceimplementation.UserService;

@RestController
@Component
public class UserController {
 
@Autowired
private Userservice userService;

@Autowired 
private Postservice postService;

@Autowired
private Friendservice friendService;



@RequestMapping("/")
public ModelAndView index() 
{
	ModelAndView modelAndView= new ModelAndView("Index.jsp");
	return modelAndView; 
}
@PostMapping("/register")
public ModelAndView userRegister(HttpServletRequest request,ModelMap map) throws ParseException {
   String redirect="";
   User user= userService.getDataByEmail(request.getParameter("email"));
   if(user==null)
   {
	   userService.insert(request);
	   redirect="Login.jsp";
   }
   else {
	   map.put("error1","email is aleady used please use another email");
   }
   ModelAndView modelAndView= new ModelAndView(redirect);
   
   return modelAndView;

}
ModelMap map;
@PostMapping("/login")
public ModelAndView login(HttpServletRequest request,ModelMap modelmap) throws UnsupportedEncodingException {
	
	String redirect;	
	
	if(userService.login(request,modelmap))
	{
		redirect="HomePage.jsp";
		String email=request.getParameter("email");
		 User user=userService.getDataByEmail(email);
		modelmap.put("name",user.getEmail());
		List<Post> postlist= postService.getAllPosts();
		modelmap.put("result", postlist);
	}
	else {
		redirect="Login.jsp";
		modelmap.put("error", "please give valid information");
	}
	ModelAndView modelAndView= new ModelAndView(redirect);
	return modelAndView;
}


@RequestMapping(value="/profile", method=RequestMethod.GET)
public ModelAndView profile(ModelMap map,@RequestParam String name) throws UnsupportedEncodingException
{
	User user=userService.getDataByEmail(name);
	List<Post> post= postService.userPost(user.getFirstName());
	map.put("postist",post);
	
	List<Friend> listData=new ArrayList<>();
	listData= friendService.getList(user.getId());
	List<User> friendList=new ArrayList<>();
	
	for(Friend x:listData)
	{
		 User user_firend= userService.getDataById(x.getReciever());
		 friendList.add(user_firend);
	}
	 map.put("user", user);
	 map.put("friendList", friendList);
	  ModelAndView modelAndView= new ModelAndView("UserProfile.jsp");
	  
	  return modelAndView;
}

// to add posts
@PostMapping("/addPost")
public ModelAndView addpost(HttpServletRequest request,@RequestParam("image_url") MultipartFile file,ModelMap map) throws UnsupportedEncodingException
{
    postService.savePost(request,file);
	ModelAndView modelAndView= new ModelAndView("UserProfile.jsp");
	User user=userService.getDataByName(request.getParameter("userName"));
	map.put("user", user);
	 String name= user.getFirstName();
	 List<Post> post= postService.userPost(name);
	 map.put("postList",post);
	
	
	return modelAndView;
}

// to search friend

@RequestMapping(value="/searchFriend", method=RequestMethod.POST)
public ModelAndView searchfriend(ModelMap map,@RequestParam String name,HttpServletRequest request) throws UnsupportedEncodingException
{
	String friendName=request.getParameter("friendName");
	 List<Post> post= postService.userPost(name);
	 map.put("postList",post);
	 User user= userService.getDataByEmail(name);
	User friendData=userService.getDataByEmail(friendName);
	map.put("friend_data", friendData);
	    List<Friend> listData=new ArrayList<>();
		listData= friendService.getList(user.getId());
		List<User> friendList=new ArrayList<>();
		
		for(Friend x:listData)
		{
			 User user1= userService.getDataById(x.getReciever());
			 System.out.println(x.getReciever());
			 friendList.add(user1);
		}
		 map.put("user", user);
		 map.put("friendList", friendList);
	  ModelAndView modelAndView= new ModelAndView("UserProfile.jsp");
	  return modelAndView;
}
// friend request

@RequestMapping(value="/addFriend", method=RequestMethod.GET)
public ModelAndView profile(ModelMap map,@RequestParam String userName,@RequestParam int friendId) throws UnsupportedEncodingException, SQLException
{
	 User user= userService.getDataByEmail(userName);
	 friendService.saveFriend(user.getId(), friendId);
	 List<Post> post= postService.userPost(userName);
	 map.put("postlist",post);
	 List<Friend> listData=new ArrayList<>();
		listData= friendService.getList(user.getId());
		List<User> friendList=new ArrayList<>();
		
		for(Friend x:listData)
		{
			 User user_friend= userService.getDataById(x.getReciever());
			 friendList.add(user_friend);
		}
		 map.put("user", user);
		 map.put("friendList", friendList);
	 ModelAndView modelAndView= new ModelAndView("UserProfile.jsp");
	 return modelAndView;
}
  
//post deleting by user
@RequestMapping(value="/deletePost", method=RequestMethod.GET)
public ModelAndView deletepost(ModelMap map,@RequestParam String userName,@RequestParam int id) throws UnsupportedEncodingException
{
	 ModelAndView modelAndView= new ModelAndView("UserProfile.jsp");
	 User user= userService.getDataByEmail(userName);
	 postService.deletePost(id);
	 List<Post> post= postService.userPost(userName);
	 map.put("postlist",post);
	 List<Friend> listData=new ArrayList<>();
	 listData= friendService.getList(user.getId());
	 List<User> friendList=new ArrayList<>();
		for(Friend x:listData)
		{
			 User user_friend= userService.getDataById(x.getReciever());
			 friendList.add(user_friend);
		}
		 map.put("user", user);
		 map.put("friendlist", friendList);

	return modelAndView;
}

@RequestMapping(value="/completeDetails", method=RequestMethod.GET) 
public ModelAndView viewFriendData(ModelMap map,@RequestParam String name,@RequestParam String userName) throws NullPointerException
{
	ModelAndView modelAndView= new ModelAndView("FriendFata.jsp");
	User user=userService.getDataByName(name);
	map.put("friend_data", user);
	map.put("name", userName);
	return modelAndView;
	
}

@PostMapping("/updateUser")
public ModelAndView updateDetails(HttpServletRequest request,ModelMap map) throws ParseException
{
	userService.updateUser(request);
	 User user= userService.getDataByEmail(request.getParameter("firstName"));
	List<Friend> listData=new ArrayList<>();
	listData= friendService.getList(user.getId());
	List<User> friendList=new ArrayList<>();
	
	for(Friend x:listData)
	{
		 User user_friend= userService.getDataById(x.getReciever());
		 friendList.add(user_friend);
	}
	 map.put("user", user);
	 map.put("friendList", friendList);
	  ModelAndView modelAndView= new ModelAndView("UserProfile.jsp");
	return modelAndView;
}



}