package com.socialmediapage.digipage.posts;

import java.util.ArrayList;
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

public String Doctor(ModelMap model) {
    
    List<post> doctor=new ArrayList<post>();
   postrepository.findAll().forEach(i->doctor.add(i));
   model.addAttribute("result", doctor);
  
   return "posts.jsp";
}


public void savePost(HttpServletRequest request)
{
	post post_data= new post();
	post_data.setDescription(request.getParameter("description"));
	post_data.setImage_url(request.getParameter("image_url"));
	post_data.setLikes(Integer.parseInt(request.getParameter("likes")));
	post_data.setUser_id(Integer.parseInt(request.getParameter("user_id")));
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

}