package com.socialmediapage.digipage.friends;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend,Integer> {
	
	List<Friend> findAllBysender(int sender);

}
