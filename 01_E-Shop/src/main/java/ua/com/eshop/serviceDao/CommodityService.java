package ua.com.eshop.serviceDao;

import java.util.List;

import ua.com.eshop.entity.Commodity;



public interface CommodityService {
	
	void save(Commodity commodity) throws Exception;
	List<Commodity> findAll();
	public Commodity findOne(int id);
	public void delete(int id);

}
