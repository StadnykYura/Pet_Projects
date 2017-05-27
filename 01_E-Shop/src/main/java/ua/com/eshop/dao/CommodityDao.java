package ua.com.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.eshop.entity.Commodity;


public interface CommodityDao extends JpaRepository<Commodity, Integer> {

	Commodity findByName(String name);
	
}
