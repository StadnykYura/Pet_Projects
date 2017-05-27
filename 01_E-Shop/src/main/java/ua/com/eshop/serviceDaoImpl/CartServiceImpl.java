package ua.com.eshop.serviceDaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.eshop.dao.CartDao;
import ua.com.eshop.entity.Cart;
import ua.com.eshop.serviceDao.CartService;


public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	
	public void save(Cart cart) {
		cartDao.save(cart);
		
	}

	public List<Cart> findAll() {
		
		return cartDao.findAll();
	}

	public Cart findOne(int id) {
		
		return cartDao.findOne(id);
	}

	public void delete(int id) {
		cartDao.delete(id);
		
	}

}
