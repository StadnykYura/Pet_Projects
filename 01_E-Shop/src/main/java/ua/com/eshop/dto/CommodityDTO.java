package ua.com.eshop.dto;

public class CommodityDTO {

	private String name;
	private int pricePerOne;
	
	public CommodityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommodityDTO(String name, int pricePerOne) {
		super();
		this.name = name;
		this.pricePerOne = pricePerOne;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerOne() {
		return pricePerOne;
	}

	public void setPricePerOne(int pricePerOne) {
		this.pricePerOne = pricePerOne;
	}

	@Override
	public String toString() {
		return "CommodityDTO [name=" + name + ", pricePerOne=" + pricePerOne + "]";
	}
	
	
	
}
