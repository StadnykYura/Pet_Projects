package ua.com.eshop.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Cart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDateTime buyDate;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="cart_commodity",
	joinColumns= @JoinColumn(name="id_cart"),
	inverseJoinColumns=@JoinColumn(name="id_commodity"))
	private List<Commodity> commodities = new ArrayList<Commodity>();
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Cart(LocalDateTime buyDate) {
		super();
		this.buyDate = buyDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(LocalDateTime buyDate) {
		this.buyDate = buyDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}
	
	
	
	
	
	
}
