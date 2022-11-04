package com.socialmediapage.digipage.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.socialmediapage.digipage.bean.Post;

public interface Postservice {



	List<Post> userPost(String uname) throws UnsupportedEncodingException;
	void deletePost(int id);
	void savePost(HttpServletRequest request, MultipartFile file);
	List<Post> getAllPosts() throws UnsupportedEncodingException;

}
