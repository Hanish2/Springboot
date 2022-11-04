package com.socialmediapage.digipage.interfaces;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.socialmediapage.digipage.entity.Message;

public interface Messageservice {



	void sendMessage(HttpServletRequest request);

	List<Message> getChat();

}
