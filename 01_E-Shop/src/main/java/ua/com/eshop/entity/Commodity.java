package ua.com.eshop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Commodity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int pricePerOne;
	
	
	@ManyToMany
	@JoinTable(name="cart_commodity",
	joinColumns= @JoinColumn(name="id_commodity"),
	inverseJoinColumns=@JoinColumn(name="id_cart"))
	private List<Cart> carts;
	
	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public Commodity(String name, String description, int pricePerOne) {
		super();
		this.name = name;
		this.description = description;
		this.pricePerOne = pricePerOne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPricePerOne() {
		return pricePerOne;
	}

	public void setPricePerOne(int pricePerOne) {
		this.pricePerOne = pricePerOne;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", pricePerOne=" + pricePerOne + "]";
	}
	
	
	
	
	
	
	
}
