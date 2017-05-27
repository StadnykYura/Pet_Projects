package ua.com.eshop.serviceDaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.hibernate.Hibernate;


import ua.com.eshop.dao.CommodityDao;
import ua.com.eshop.entity.Commodity;
import ua.com.eshop.serviceDao.CommodityService;
import ua.com.eshop.validation.Validator;


@Service
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;


	public void save(Commodity commodity) throws Exception{
		
		validator.validate(commodity);
		
		commodityDao.save(commodity);
		
	}

	public List<Commodity> findAll() {
		
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);
		
	}

}
