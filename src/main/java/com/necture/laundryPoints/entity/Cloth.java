package com.necture.laundryPoints.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cloth")
public class Cloth {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;

	private String clothName;

	private double price;
	
	@OneToMany(mappedBy = "cloth")
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();


	public UUID getId() {
		return id;
	}

	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cloth [id=" + id + ", clothName=" + clothName + ", price=" + price + "]";
	}

}
