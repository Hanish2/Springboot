package com.socialmediapage.digipage.posts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.socialmediapage.digipage.user.UserRepository;

@Service
public class postservice {
@Autowired
 private PostRepository postrepository;

public String getallposts(ModelMap model) {
    
    List<post> postlist=new ArrayList<post>();
   postrepository.findAll().forEach(i->postlist.add(i));
   model.addAttribute("result", postlist);
  
   return "posts.jsp";
}


public void savePost(HttpServletRequest request)
{
	post post_data= new post();
	post_data.setDescription(request.getParameter("description"));
	post_data.setImage_url(request.getParameter("image_url"));
	post_data.setLikes(Integer.parseInt(request.getParameter("likes")));
	post_data.setuname(request.getParameter("user_id"));
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");   
	post_data.setTimestamp(date);
	System.out.println(date);
	postrepository.save(post_data);
    //List<post> result= getallposts();
//	return result;
}
//
//public List<post> deletepost(int post_id)
//{
//	postrepository.deleteById(post_id);
//	List<post> result= getallposts();
//	return result;
//}
public List<post> userpost(String uname)
{
	List<post> userpostlist= new ArrayList<>();
	postrepository.findAllByuname(uname).forEach(x->userpostlist.add(x));
	return userpostlist;
}
}