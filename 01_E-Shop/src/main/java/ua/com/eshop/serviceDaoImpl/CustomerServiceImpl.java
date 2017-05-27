package ua.com.eshop.serviceDaoImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.eshop.dao.CartDao;
import ua.com.eshop.dao.CommodityDao;
import ua.com.eshop.dao.CustomerDao;
import ua.com.eshop.entity.Cart;
import ua.com.eshop.entity.Commodity;
import ua.com.eshop.entity.Customer;
import ua.com.eshop.entity.Role;
import ua.com.eshop.serviceDao.CustomerService;
import ua.com.eshop.validation.Validator;




@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;
	
	
	
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		return customerDao.findByName(name);
	}

	public void save(Customer customer) throws Exception {
		
		validator.validate(customer);
		
		customer.setRole(Role.ROLE_CUSTOMER);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
		
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findOne(int id) {
		return customerDao.findOne(id);
	}

	public void delete(int id) {
		customerDao.delete(id);
		
	}
	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + customer.getName() + "/" + multipartFile.getOriginalFilename();

	    customer.setPathImage("resources/" + customer.getName() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + customer.getName() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    customerDao.save(customer);
	}

	public Customer findByUuid(String uuid) {
		return customerDao.findByUuid(uuid);
	}

	public void update(Customer customer) {
		customerDao.save(customer);
		
	}
	
	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {

		request.getSession(false);
		Commodity commodity = commodityDao.findOne(id);

		Cookie cookieCommodity = new Cookie(commodity.getName(), String.valueOf(commodity.getId()));
		cookieCommodity.setMaxAge(24 * 60 * 60 * 60);
		cookieCommodity.setHttpOnly(true);
		cookieCommodity.setPath("/");

		response.addCookie(cookieCommodity);
		return cookieCommodity;

	}

	public List<Commodity> customerCommoditiesCookie(HttpServletRequest request) {

		request.getSession(false);
		List<Commodity> commodities = new ArrayList();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {

			} 

			else {
				commodities.add(commodityDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return commodities;

	}

	@Transactional
	public void confirmOrder(Principal principal, HttpServletRequest request, HttpServletResponse response) {

		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));
		Cart cart = new Cart(LocalDateTime.now());
//		List<Commodity> commodities = new ArrayList<Commodity>();
		cartDao.saveAndFlush(cart);
		
		for(Cookie c : request.getCookies()) {
			if (c.getName().equals("JSESSIONID")) {
				
			} 
//			else if (c.getName().equals(null)) {
//				return;
//			} 
			else {
				cart.getCommodities().add(commodityDao.findOne(Integer.parseInt(c.getValue())));	
			}
		}
		cart.setCustomer(customer);
		
		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, response);

	}

	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);

	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
		for (int i = 0; i < cookies.length; i++) {
			if (id.equals(cookies[i].getValue())) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setHttpOnly(true);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	public void sortCookie(Cookie[] cookies, HttpServletResponse response) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("JSESSIONID")){
			
			} else {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setHttpOnly(true);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
	
	public boolean cookieExist(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies.length <= 1) {
			return true;
		} else {
			 return false;
		}
	}
		
	
}
