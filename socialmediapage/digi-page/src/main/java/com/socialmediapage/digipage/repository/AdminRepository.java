package com.socialmediapage.digipage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmediapage.digipage.entity.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	
Admin findByemail(String email);

}
