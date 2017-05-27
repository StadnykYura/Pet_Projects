package ua.com.eshop.serviceDao;

import java.util.List;

import ua.com.eshop.entity.Cart;


public interface CartService {

	void save(Cart cart);
	List<Cart> findAll();
	public Cart findOne(int id);
	public void delete(int id);
	
	
}
