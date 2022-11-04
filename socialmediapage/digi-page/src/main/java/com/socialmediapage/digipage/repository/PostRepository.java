package com.socialmediapage.digipage.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmediapage.digipage.entity.Post;

@Repository
public interface PostRepository  extends CrudRepository<Post, Integer>{
  List<Post> findAllByuserName(String userName);
  
}
