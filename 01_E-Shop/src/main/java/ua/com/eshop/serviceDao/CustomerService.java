package ua.com.eshop.serviceDao;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import ua.com.eshop.entity.Commodity;
import ua.com.eshop.entity.Customer;



public interface CustomerService {

	void save(Customer customer) throws Exception;
	List<Customer> findAll();
	public Customer findOne(int id);
	public void delete(int id);
	
	public void saveImage(Principal principal, MultipartFile multipartFile);
	
	Customer findByUuid (String uuid);
	
	void update (Customer customer);
	
// for cookie
    
    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
    
    List<Commodity> customerCommoditiesCookie(HttpServletRequest request);
    
    public void confirmOrder(Principal principal, HttpServletRequest request, HttpServletResponse response);
    
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
    
    public boolean cookieExist(HttpServletRequest request);

}
	

