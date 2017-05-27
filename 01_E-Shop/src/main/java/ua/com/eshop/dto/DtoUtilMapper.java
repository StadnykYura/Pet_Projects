package ua.com.eshop.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.eshop.entity.Commodity;
import ua.com.eshop.entity.Customer;

public class DtoUtilMapper {
	
	public static List<CustomerDTO> customersToCustomersDTO(List<Customer> customers) {
		
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		
		for (Customer customer : customers) {
			
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setId(customer.getId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmail(customer.getEmail());
			
			customerDTOs.add(customerDTO);
		}
		
		return customerDTOs;
	}
	
public static List<CommodityDTO> commoditiesToCommoditiesDTO(List<Commodity> commodities) {
		
		List<CommodityDTO> commodityDTOs = new ArrayList<CommodityDTO>();
		
		for (Commodity commodity : commodities) {
			
			CommodityDTO commodityDTO = new CommodityDTO();
			commodityDTO.setName(commodity.getName());
			commodityDTO.setPricePerOne(commodity.getPricePerOne());
			
			commodityDTOs.add(commodityDTO);
		}
		
		return commodityDTOs;
	}
	

}
