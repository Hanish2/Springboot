package com.socialmediapage.digipage.messages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService{
@Autowired
private ChatRepository repo;
	public List<Message> getchat(){
		List<Message> list= new ArrayList();
		repo.findAll().forEach(x->list.add(x));
		return list;
	}
	public void sendmessage(HttpServletRequest request) {
		Message message= new Message();
		message.setName(request.getParameter("name"));
		message.setContent(request.getParameter("content"));
		Date date = Calendar.getInstance().getTime(); 
		message.setTimestamp(date);
		System.out.println("data added"+" "+message.getName());
		repo.save(message);
	}
	
	
}
