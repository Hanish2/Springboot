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

@Controller
@Component
public class UserController {

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
public ModelAndView login(HttpServletRequest request) {
	
	String redirect;	
	
	if(userservice.login(request))
	{
	//	map.addAttribute("email", request.getAttribute("email"));
		redirect="homepage.jsp";
	}
	else {
		redirect="login.jsp";
	}
	ModelAndView mv= new ModelAndView(redirect);
	return mv;
}

@PostMapping("/addpost")
public ModelAndView addpost(HttpServletRequest request)
{
    postservice.savePost(request);
	ModelAndView mv= new ModelAndView("userprofile.jsp");
	//System.out.println(post_list);
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
public ModelAndView Doctor(ModelMap model) {
  
  ModelAndView mv= new ModelAndView(postservice.Doctor(model));
  return mv;
    
}
} 
