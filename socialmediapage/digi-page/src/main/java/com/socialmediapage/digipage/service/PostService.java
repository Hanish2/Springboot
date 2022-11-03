package com.socialmediapage.digipage.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.socialmediapage.digipage.entity.Post;
import com.socialmediapage.digipage.repository.PostRepository;
import com.socialmediapage.digipage.repository.UserRepository;

import io.netty.handler.codec.base64.Base64Encoder;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Service
public class PostService {
@Autowired
 private PostRepository postrepository;

public List<Post> getallposts() throws UnsupportedEncodingException {
    
    List<Post> postlist=new ArrayList<Post>();
   postrepository.findAll().forEach(i->postlist.add(i));
   for(Post x:postlist)
	{
		byte[] imgdata=x.getImage_url();
		if(imgdata!=null)
		{
			String base64EncodedImageBytes = Base64.getEncoder().encodeToString(imgdata);
		    x.setBase64image(base64EncodedImageBytes);
		}
	}
 
  
   return postlist;
}


public void savePost(HttpServletRequest request,MultipartFile file,String directory)
{

//	MultipartFile file=request.getPart("image_url");
	
	
	Post post_data= new Post();
	post_data.setDescription(request.getParameter("description"));

	//post_data.setImage_url(request.getParameter("image_url"));
	post_data.setLikes(Integer.parseInt(request.getParameter("likes")));
	post_data.setuname(request.getParameter("user_id"));
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");   
	post_data.setTimestamp(date);
	try {
		InputStream stream= file.getInputStream();
	//	FileOutputStream fos= new FileOutputStream(directory+File.separator+file.getOriginalFilename()); 
		byte[] buffer= new byte[stream.available()];
	    stream.read(buffer);
	 //   fos.write(buffer);
	    post_data.setImage_url(buffer);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
public List<Post> userpost(String uname) throws UnsupportedEncodingException
{
	List<Post> userpostlist= new ArrayList<>();
	postrepository.findAllByuname(uname).forEach(x->userpostlist.add(x));
	for(Post x:userpostlist)
	{
		byte[] imgdata=x.getImage_url();
		if(imgdata!=null)
		{
		String base64EncodedImageBytes = Base64.getEncoder().encodeToString(imgdata);
	    x.setBase64image(base64EncodedImageBytes);
		}
	    
	}
	
	return userpostlist;
}
public void deletepost(int id)
{
	postrepository.deleteById(id);
	System.out.println("post data deleted");
}
}