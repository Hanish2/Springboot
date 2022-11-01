package com.socialmediapage.digipage.friends;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
	@Autowired
	private FriendRepository friendrepo;
public void savefriend(int id1,int id2)
{
	Friend friend= new Friend();
	friend.setSender(id1);
	friend.setReciever(id2);
	friend.setStatus("true");
	friendrepo.save(friend);
	System.out.println(friend.getId());
	System.out.println("data saved");
}
public List<Friend> getlist(int id)
{
	List<Friend> list=new ArrayList();
	friendrepo.findAllBysender(id).forEach(x->list.add(x));
	System.out.println(list);
	return list;
	
}
}
