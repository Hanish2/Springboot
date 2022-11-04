package com.socialmediapage.digipage.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmediapage.digipage.entity.Friend;
import com.socialmediapage.digipage.interfaces.Friendservice;
import com.socialmediapage.digipage.repository.FriendRepository;

@Service
public class FriendService implements Friendservice {
	@Autowired
	private FriendRepository friendRepository;
	
@Override
public void saveFriend(int senderId,int recieverId) throws NullPointerException
{
	Friend friend= new Friend();
	friend.setSender(senderId);
	friend.setReciever(recieverId);
	friend.setStatus("true");
	friendRepository.save(friend);
}

@Override
public List<Friend> getList(int id) throws NullPointerException
{
	List<Friend> list=new ArrayList();
	friendRepository.findAllBysender(id).forEach(x->list.add(x));
	return list;
	
}
}
