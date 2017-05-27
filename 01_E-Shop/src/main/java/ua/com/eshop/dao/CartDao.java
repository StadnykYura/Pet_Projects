package ua.com.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.eshop.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{

	
	
}
