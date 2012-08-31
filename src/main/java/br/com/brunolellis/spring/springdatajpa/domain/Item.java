package br.com.brunolellis.spring.springdatajpa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Order order;

	private String product;

	private double price;

	private int quantity;
	
	public Item() {
		
	}
	
	public Item(Order order, String product, double price, int quantity) {
		this.order = order;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public Order getOrder() {
		return order;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

}
