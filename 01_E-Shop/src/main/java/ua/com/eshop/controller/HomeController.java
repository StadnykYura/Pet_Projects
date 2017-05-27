package ua.com.eshop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.eshop.dto.DtoUtilMapper;
import ua.com.eshop.entity.Commodity;
import ua.com.eshop.serviceDao.CommodityService;
import ua.com.eshop.serviceDao.CustomerService;


@Controller
public class HomeController {
	
	@Autowired
	private CommodityService commodityService;
	
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value={ "/", "/home" }, method=RequestMethod.GET)
	public String home(Model model){
//		model.addAttribute("commodities",  commodityService.findAll());
		model.addAttribute("commoditiesdto", DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
		
		return "home";
	}
	
	@RequestMapping(value= "/listOfProducts", method=RequestMethod.GET)
	public String listOfProducts(Model model){
		model.addAttribute("commodities",  commodityService.findAll());
//		model.addAttribute("commoditiesdto", DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
		
		return "listOfProducts";
	}
	
	@RequestMapping(value= "/mainPage", method=RequestMethod.GET)
	public String mainPage(){
		
		return "home";
	}
	
	
}
