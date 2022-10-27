package com.socialmediapage.digipage.user;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.socialmediapage.digipage.posts.*;

@RestController
@Component
public class UserController {
 User user;
@Autowired
private UserService userservice;

@Autowired 
private postservice postservice;

@RequestMapping("/")
public ModelAndView index() 
{
	ModelAndView mv= new ModelAndView("index.jsp");
	return mv;
}
@PostMapping("/register")
public ModelAndView  value1(HttpServletRequest request) throws ParseException {
	ModelAndView mv= new ModelAndView("login.jsp");
   userservice.insert(request);
   return mv;
//  return "pages/index.jsp";

}
ModelMap map;
@PostMapping("/login")
public ModelAndView login(HttpServletRequest request,ModelMap modelmap) {
	
	String redirect;	
	
	if(userservice.login(request,modelmap))
	{
		redirect="homepage.jsp";
		String email=request.getParameter("email");
		user=userservice.getData(email);
	}
	else {
		redirect="login.jsp";
	}
	ModelAndView mv= new ModelAndView(redirect);
	return mv;
}

@PostMapping("/addpost")
public ModelAndView addpost(HttpServletRequest request,ModelMap map)
{
    postservice.savePost(request);
	ModelAndView mv= new ModelAndView("userprofile.jsp");
	//System.out.println(post_list);
	map.put("user", user);
	System.out.println("data added");
	
	return mv;
}

//
//@GetMapping("/posts")
//public String displayUser() {
////    String redirect=;
////	ModelAndView mv= new ModelAndView(redirect);
//	//System.out.println(redirect);
//     postservice.getallposts() ;
//      
//  }	


@GetMapping("/posts")
public ModelAndView getalldata(ModelMap model) {
  
  ModelAndView mv= new ModelAndView(postservice.getallposts(model));
  return mv;
    
}

@GetMapping("/profile")
public ModelAndView profile(ModelMap map)
{
	
	  map.put("user", user);
	 String name= user.getFirstname();
	 List<post> post= postservice.userpost(name);
	 map.put("postlist",post);
	  ModelAndView mv= new ModelAndView("userprofile.jsp");
	  return mv;
}
}