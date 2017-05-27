package ua.com.eshop.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.eshop.entity.Customer;
import ua.com.eshop.serviceDao.CommodityService;
import ua.com.eshop.serviceDao.CustomerService;

@Controller
public class CookieController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private  CommodityService commodityService;
	
	
	@RequestMapping(value = "/buyCommodity/{id}", method = RequestMethod.GET)
	public String buyBook(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

		customerService.intoBasket(Integer.parseInt(id), request, response);

		return "redirect:/listOfProducts";
	}



	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(Principal principal, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		customerService.confirmOrder(principal, request, response);
		
		Customer customer = customerService.findOne(Integer.parseInt(principal.getName()));

		model.addAttribute("customer", customer);

		return "confirmOrder";
	}


	@RequestMapping(value = "/deleteFromOrder/{id}", method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id, HttpServletRequest request,
                               HttpServletResponse response) {

        customerService.deleteCookieFromOrder(id, request, response);

        return "redirect:/basket";
    }


    @RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(HttpServletRequest request, Model model){

//    	Customer customer = customerService.findOne(Integer.parseInt(principal.getName()));
//
//		model.addAttribute("customer", customer);
    	
		model.addAttribute("commodities", customerService.customerCommoditiesCookie(request));
		
		model.addAttribute("cookies", customerService.cookieExist(request));

		return "basket";
	}

	
}
