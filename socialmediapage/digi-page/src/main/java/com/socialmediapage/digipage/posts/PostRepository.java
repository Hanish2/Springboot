package com.socialmediapage.digipage.posts;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends CrudRepository<post, Integer>{
  List<post> findAllByuname(String uname);
	
}
