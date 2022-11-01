package com.socialmediapage.digipage.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	
Admin findByemail(String email);

}
