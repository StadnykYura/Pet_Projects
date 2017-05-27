package ua.com.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.eshop.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Customer findByName(String name);
	Customer findByTelephone(String telephone);
	
	@Query("select c from Customer c where c.uuid =:uuid")
	Customer findByUuid(@Param("uuid") String uuid);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email =:email")
	boolean customerExistsByEmail(@Param("email") String email);
	
	
	
}
