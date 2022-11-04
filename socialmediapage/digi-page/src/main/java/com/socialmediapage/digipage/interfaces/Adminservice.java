package com.socialmediapage.digipage.interfaces;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.socialmediapage.digipage.entity.Post;
import com.socialmediapage.digipage.entity.User;

public interface Adminservice {

	void updateUser(HttpServletRequest request) throws ParseException;
	void save(HttpServletRequest request);
	boolean login(HttpServletRequest request);
	void deleteUser(int id);
	void deletePost(int id);
	List<Post> getAllPosts();
	List<User> getAllUserList();


}
