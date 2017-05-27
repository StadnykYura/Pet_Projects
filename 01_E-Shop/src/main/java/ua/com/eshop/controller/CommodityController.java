package ua.com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.eshop.dto.DtoUtilMapper;
import ua.com.eshop.entity.Commodity;
import ua.com.eshop.serviceDao.CommodityService;



@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	
	@RequestMapping(value = "/newCommodity", method = RequestMethod.GET)
	public String newGood(Model model) {
		
		model.addAttribute("commoditiesdto", DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
		model.addAttribute("commodities", commodityService.findAll());
		model.addAttribute("commodity", new Commodity());
		return "newCommodity";
	}

	@RequestMapping(value = "/saveCommodity", method = RequestMethod.POST)

	public String saveGood(@ModelAttribute Commodity commodity, Model model) {

//		Commodity commodity = new Commodity(commodityName, commodityDescription, commodityPricePerOne);
// /*@RequestParam String commodityName, @RequestParam String commodityDescription,
//		@RequestParam int commodityPricePerOne*/			
		try {
			commodityService.save(commodity);
		} catch (Exception ex) {
			model.addAttribute("exceptions", ex.getMessage());
			return "newCommodity";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/deleteCommodity/{id}", method = RequestMethod.GET)
	public String deleteGood(@PathVariable int id) {
		
		commodityService.delete(id);
		
		return "redirect:/newCommodity";
	}
	
	
	
}
