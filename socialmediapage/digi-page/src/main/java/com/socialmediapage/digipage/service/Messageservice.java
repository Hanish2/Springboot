package com.socialmediapage.digipage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.socialmediapage.digipage.bean.Message;

public interface Messageservice {



	void sendMessage(HttpServletRequest request);

	List<Message> getChat();

}
