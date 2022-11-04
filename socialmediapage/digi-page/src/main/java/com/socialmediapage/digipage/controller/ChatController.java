package com.socialmediapage.digipage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.socialmediapage.digipage.entity.Message;
import com.socialmediapage.digipage.service.MessageService;

@Controller
public class ChatController {
@Autowired
MessageService service;
	
	@RequestMapping(value="/chatbox")
	public ModelAndView getContent(ModelMap map,@RequestParam String name) 
	{
		ModelAndView modelAndView= new ModelAndView("Chat.jsp");
		List<Message> list= service.getChat();
		map.put("chat_data", list);
		map.put("name", name);
		return modelAndView;
	}
	
	@RequestMapping(value="/sendchat")
	public ModelAndView putchat(ModelMap map,HttpServletRequest request)
	{
		ModelAndView modelAndView= new ModelAndView("Chat.jsp");
	    service.sendMessage(request);
		List<Message> list=service.getChat();
		map.put("chat_data", list);
		map.put("name", request.getParameter("name"));
		return modelAndView;
	}	
}
