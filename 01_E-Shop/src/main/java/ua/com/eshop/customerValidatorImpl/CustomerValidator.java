package ua.com.eshop.customerValidatorImpl;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import ua.com.eshop.dao.CustomerDao;
import ua.com.eshop.entity.Customer;
import ua.com.eshop.validation.Validator;



@Component("customerValidator")
public class CustomerValidator implements Validator{

	@Autowired
	private CustomerDao customerDao;
	
	public void validate(Object object) throws Exception {
		Customer customer = (Customer) object;
		
		if(customer.getName().isEmpty()){
			throw new CustomerValidationException(CustomerValidationMessages.EMPTY_CUSTOMERNAME_FIELD);
		}
		
		if (customerDao.findByName(customer.getName()) != null){
			throw new CustomerValidationException(CustomerValidationMessages.NAME_ALREADY_EXIST);
		}
		
		if(customerDao.customerExistsByEmail(customer.getEmail())){
			throw new CustomerValidationException(CustomerValidationMessages.EMAIL_ALREADY_EXIST);
		}
		if(customer.getEmail().isEmpty()){
			throw new CustomerValidationException(CustomerValidationMessages.EMPTY_EMAIl_FIELD);
		}
		if(customer.getPassword().isEmpty()){
			throw new CustomerValidationException(CustomerValidationMessages.EMPTY_PASSWORD_FIELD);
		}
		if(customer.getTelephone().isEmpty()){
			throw new CustomerValidationException(CustomerValidationMessages.EMPTY_TELEPHONE_FIELD);
		}
		if(customerDao.findByTelephone(customer.getTelephone()) != null){
			throw new CustomerValidationException(CustomerValidationMessages.TELEPHONE_ALREADY_EXIST);
		}
		
		
		
		
	}

}
