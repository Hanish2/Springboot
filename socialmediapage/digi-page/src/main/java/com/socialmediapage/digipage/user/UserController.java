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

public static String directory="D:\\socialmediapage\\digi-page\\src\\main\\resources\\static\\images";

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
public ModelAndView addpost(HttpServletRequest request,@RequestParam("image_url") MultipartFile file,ModelMap map) throws UnsupportedEncodingException
{
    postservice.savePost(request,file,directory);
	ModelAndView mv= new ModelAndView("userprofile.jsp");
	//System.out.println(post_list);
	map.put("user", user);
	 String name= user.getFirstname();
	 List<post> post= postservice.userpost(name);
	 map.put("postlist",post);
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
public ModelAndView getalldata(ModelMap model) throws UnsupportedEncodingException {
  
  ModelAndView mv= new ModelAndView(postservice.getallposts(model));
  return mv;
    
}

@GetMapping("/profile")
public ModelAndView profile(ModelMap map) throws UnsupportedEncodingException
{
	
	  map.put("user", user);
	 String name= user.getFirstname();
	 List<post> post= postservice.userpost(name);
	 map.put("postlist",post);
	  ModelAndView mv= new ModelAndView("userprofile.jsp");
	  return mv;
}
//@PostMapping("/addimages")
//public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file)
//{
//    System.out.println();
//	
//	try {
//		InputStream stream= file.getInputStream();
//		FileOutputStream fos= new FileOutputStream(directory); 
//		byte[] buffer= new byte[stream.available()];
//	    stream.read(buffer);
//	    fos.write(buffer);
//	    fos.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	return ResponseEntity.ok("working fine");
//}
}