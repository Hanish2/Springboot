package com.socialmediapage.digipage.user;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByemail(String email);
//   boolean findByemailAndpassword(String email,String password);
	User findById(int id);
	
	User findByfirstname(String firstname);
}
