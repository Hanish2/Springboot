package com.socialmediapage.digipage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.socialmediapage.digipage.entity.Friend;

public interface FriendRepository extends CrudRepository<Friend,Integer> {
	
	List<Friend> findAllBysender(int sender);

}
