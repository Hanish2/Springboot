package com.socialmediapage.digipage.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface friendrepository extends CrudRepository<friends, Integer>{
	 boolean existsByFirstUserAndSecondUser(User first,User second);

	    List<friends> findByFirstUser(User user);
	    List<friends> findBySecondUser(User user);
	    User findById(int id);
}
