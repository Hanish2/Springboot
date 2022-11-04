package com.socialmediapage.digipage.controller;

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

import com.socialmediapage.digipage.entity.Post;
import com.socialmediapage.digipage.entity.User;
import com.socialmediapage.digipage.service.AdminService;
import com.socialmediapage.digipage.service.UserService;

@RestController
public class AdminController {
@Autowired
AdminService adminService;

@Autowired
UserService userService;

@RequestMapping("/adminLogin")
public ModelAndView login(HttpServletRequest request)
{
	String redirect="";
	if(adminService.login(request))
	{
		redirect="AdminHomepage.jsp";
	}
	else {
		redirect="AdminLogin.jsp";
	}
	ModelAndView modelAndView= new ModelAndView(redirect);
	return modelAndView;
}

@RequestMapping("/userList")
public ModelAndView getUserList(ModelMap map)
{
	ModelAndView modelAndView=new ModelAndView("AdminUserList.jsp");
	List<User> userList=adminService.getAllUserList();
	map.put("userList", userList);
	return modelAndView;
}

@RequestMapping("/postList")
public ModelAndView getPostList(ModelMap map) {
	ModelAndView modelAndView= new ModelAndView("AdminPostList.jsp");
	List<Post> postList=adminService.getAllPosts();
	map.put("postList", postList);
	return modelAndView;
}

@PostMapping("/adminRegister")
public ModelAndView adminRegister(HttpServletRequest request)
{
	ModelAndView modelAndView= new ModelAndView("AdminLogin.jsp");
	adminService.save(request);
	return modelAndView;
}
@RequestMapping(value="/deleteuser", method=RequestMethod.GET)
public ModelAndView adminUserDelete(@RequestParam int id,ModelMap map) {
	ModelAndView modelAndView= new ModelAndView("AdminUserList.jsp");
	adminService.deleteUser(id);
	List<User> userList=adminService.getAllUserList();
	map.put("userList", userList);

	return modelAndView;
}
@RequestMapping(value="/adminDeletePost", method=RequestMethod.GET)
public ModelAndView adminPostDelete(@RequestParam int id,ModelMap map) {
	ModelAndView modelAndView= new ModelAndView("AdminAostList.jsp");
	adminService.deletePost(id);
	List<Post> postlist=adminService.getAllPosts();
	map.put("postList", postlist);
	return modelAndView;
}

@RequestMapping(value="/adminEditUser", method=RequestMethod.GET)
public ModelAndView adminUpdateUser(@RequestParam int id,ModelMap map){
	ModelAndView modelAndView= new ModelAndView("UpdateUser.jsp");
	User user= userService.getDataById(id);
	map.put("user", user);
	return modelAndView;
}
@PostMapping("/adminUpdateUser")
public ModelAndView updateDetails(HttpServletRequest request,ModelMap map) throws ParseException
{
	ModelAndView modelAndView= new ModelAndView("AdminUserList.jsp");
	List<User> userList=adminService.getAllUserList();
	map.put("userList", userList);
	adminService.updateUser(request);
	return modelAndView;
}

}