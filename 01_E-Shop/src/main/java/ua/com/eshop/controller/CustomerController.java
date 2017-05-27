package ua.com.eshop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.eshop.entity.Customer;
import ua.com.eshop.serviceDao.CustomerService;
import ua.com.eshop.serviceDao.MailSenderService;


@Controller
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MailSenderService mailSenderService;

	
	@RequestMapping(value = {"/newCustomer", "/registration"}, method = RequestMethod.GET)
	public String newCustomer(Model model) {
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("customer", new Customer());
		return "registration";
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute Customer customer, Model model) {
		
		String uuid = UUID.randomUUID().toString();
		
		customer.setUuid(uuid);
		
		try {
			customerService.save(customer);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "registration";
		}
		
		String content = "thanks for registration";
				String mailBody = " good luck have fun good game     http://localhost:8080/01_E-Shop/confirm/" + uuid;
		
		mailSenderService.sendMail(content, mailBody, customer.getEmail());
		
		
		return "redirect:/registration";
	}
	
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable String id) {
		customerService.delete(Integer.parseInt(id));
		return "redirect:/registration";
	}
	
	
	@RequestMapping(value =  "/home", method = RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}
	
	@RequestMapping("/loginpage")
	public String login(){
		return "loginpage";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {

		Customer customer = customerService.findOne(Integer.parseInt(principal.getName()));

		model.addAttribute("customer", customer);

		return "profile";

}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	   public String saveImage(Principal principal, @RequestParam MultipartFile image){

	      customerService.saveImage(principal, image);

	   return "redirect:/profile";
	   }
	
	
	
	
	
	
	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid) {
		Customer customer = customerService.findByUuid(uuid);
		customer.setEnabled(true);
		customerService.update(customer);
		
		return "redirect:/";
		
	}

	
}