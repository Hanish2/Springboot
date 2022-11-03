package com.socialmediapage.digipage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmediapage.digipage.entity.Message;

@Repository
public interface ChatRepository extends CrudRepository<Message, Integer>{
	
}
