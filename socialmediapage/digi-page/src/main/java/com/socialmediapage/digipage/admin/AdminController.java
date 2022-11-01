package com.socialmediapage.digipage.admin;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.socialmediapage.digipage.posts.Post;
import com.socialmediapage.digipage.user.User;
import com.socialmediapage.digipage.user.UserService;

@RestController
public class AdminController {
@Autowired
AdminService adminService;

@Autowired
UserService userService;

@RequestMapping("/adminlogin")
public ModelAndView login(HttpServletRequest request)
{
	String redirect="";
	if(adminService.login(request))
	{
		redirect="adminhomepage.jsp";
	}
	else {
		redirect="adminlogin.jsp";
	}
	ModelAndView mv= new ModelAndView(redirect);
	return mv;
}

@RequestMapping("/userlist")
public ModelAndView getuserlist(ModelMap map)
{
	ModelAndView mv=new ModelAndView("adminuserlist.jsp");
	List<User> userlist=adminService.getalluserlist();
	map.put("userlist", userlist);
	return mv;
}

@RequestMapping("/postlist")
public ModelAndView getpostlist(ModelMap map) {
	ModelAndView mv= new ModelAndView("adminpostlist.jsp");
	List<Post> postList=adminService.getallposts();
	map.put("postList", postList);
	return mv;
}

@PostMapping("/adminregister")
public ModelAndView adminRegister(HttpServletRequest request)
{
	ModelAndView mv= new ModelAndView("adminlogin.jsp");
	adminService.save(request);
	return mv;
}
@RequestMapping(value="/deleteuser", method=RequestMethod.GET)
public ModelAndView adminuserdelete(@RequestParam int id,ModelMap map) {
	ModelAndView mv= new ModelAndView("adminuserlist.jsp");
	adminService.deleteuser(id);
	List<User> userlist=adminService.getalluserlist();
	map.put("userlist", userlist);

	return mv;
}
@RequestMapping(value="/admindeletepost", method=RequestMethod.GET)
public ModelAndView adminpostdelete(@RequestParam int id,ModelMap map) {
	ModelAndView mv= new ModelAndView("adminpostlist.jsp");
	adminService.deletepost(id);
	List<Post> postlist=adminService.getallposts();
	map.put("postList", postlist);
	return mv;
}

@RequestMapping(value="/adminedituser", method=RequestMethod.GET)
public ModelAndView adminupdateuser(@RequestParam int id,ModelMap map){
	ModelAndView mv= new ModelAndView("updateuser.jsp");
	User user= userService.getbyid(id);
	map.put("user", user);
	return mv;
}
@PostMapping("/adminupdateuser")
public ModelAndView updatedetails(HttpServletRequest request,ModelMap map) throws ParseException
{
	ModelAndView mv= new ModelAndView("adminuserlist.jsp");
	List<User> userlist=adminService.getalluserlist();
	map.put("userlist", userlist);
	adminService.updateUser(request);
	return mv;
}

}
