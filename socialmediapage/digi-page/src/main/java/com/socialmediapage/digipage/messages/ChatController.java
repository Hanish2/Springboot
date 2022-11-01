package com.socialmediapage.digipage.messages;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ChatController {
@Autowired
MessageService service;
	
	@RequestMapping(value="/chatbox", method=RequestMethod.GET)
	public ModelAndView getContent(ModelMap map,@RequestParam String name) 
	{
		ModelAndView mv= new ModelAndView("chat.jsp");
		List<Message> list= service.getchat();
		map.put("chat_data", list);
		map.addAttribute("name", name);
		return mv;
	}
	
	@PostMapping(value="/sendchat")
	public ModelAndView putchat(ModelMap map,HttpServletRequest request)
	{
		ModelAndView mv= new ModelAndView("chat.jsp");
	    service.sendmessage(request);
		
		List<Message> list=service.getchat();
		map.put("chat_data", list);
		return mv;
	}

	
}
