package com.socialmediapage.digipage.serviceimplementation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmediapage.digipage.entity.Message;
import com.socialmediapage.digipage.interfaces.Messageservice;
import com.socialmediapage.digipage.repository.ChatRepository;

@Service
public class MessageService  implements Messageservice{
@Autowired
private ChatRepository repo;

@Override
	public List<Message> getChat(){
		List<Message> list= new ArrayList();
		repo.findAll().forEach(x->list.add(x));
		return list;
	}

@Override
	public void sendMessage(HttpServletRequest request) {
		Message message= new Message();
		message.setName(request.getParameter("name"));
		message.setContent(request.getParameter("content"));
		Date date = Calendar.getInstance().getTime(); 
		message.setTimestamp(date);
		System.out.println("data added"+" "+message.getName());
		repo.save(message);
	}
	
	
}
