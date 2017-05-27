package ua.com.eshop.commodityValidatorImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.eshop.dao.CommodityDao;
import ua.com.eshop.entity.Commodity;
import ua.com.eshop.validation.Validator;

@Component("commodityValidator")
public class CommodityValidator implements Validator {

	@Autowired
	private CommodityDao commodityDao;

	public void validate(Object object) throws Exception {
		Commodity commodity = (Commodity) object;
		
		if(commodity.getName().isEmpty()){
			throw new CommodityValidationException(CommodityValidationMessages.EMPTY_COMMODITYNAME_FIELD);
		}
		
		if(commodityDao.findByName(commodity.getName()) != null) {
			throw new CommodityValidationException(CommodityValidationMessages.COMMODITYNAME_ALREADY_EXIST);
		}
		
		if(commodity.getDescription().isEmpty()){
			throw new CommodityValidationException(CommodityValidationMessages.EMPTY_COMMODITYDESCRIPTION_FIELD);
		}
	
		if (String.valueOf(commodity.getPricePerOne()).isEmpty()) {
			throw new CommodityValidationException(CommodityValidationMessages.EMPTY_COMMODITYPRICE_FIELD);
		}
		
		
		
		
	}
	
	
	
}
