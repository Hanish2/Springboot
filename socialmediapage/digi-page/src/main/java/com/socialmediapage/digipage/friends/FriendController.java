package com.socialmediapage.digipage.friends;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.socialmediapage.digipage.posts.Post;
import com.socialmediapage.digipage.user.User;
import com.socialmediapage.digipage.posts.*;

@RestController
public class FriendController {
	
	@Autowired
	private PostService postservice;
	
	
}
