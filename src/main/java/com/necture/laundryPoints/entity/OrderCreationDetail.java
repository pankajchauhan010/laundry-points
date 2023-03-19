package com.necture.laundryPoints.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_creation_detail")
public class OrderCreationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	private Integer quantity;

	private LocalDateTime pickUpDate;

	private LocalDateTime deliveryDate;

	private Boolean status;

	@ManyToOne
	@JoinColumn(name = "cust_id")
	@JsonIgnore
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "cloth_id")
	@JsonIgnore
	private Cloth cloth;

	@ManyToOne
	@JoinColumn(name = "cust_pick_up_addr")
	@JsonIgnore
	private CustomerClothPickUpAddress custPickUpAddress;

	@ManyToOne
	@JoinColumn(name = "cust_delivery_addr")
	@JsonIgnore
	private CustomerClothDeliveryAddress custDeliveryAddress;

	public UUID getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(LocalDateTime pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cloth getCloth() {
		return cloth;
	}

	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}

	public CustomerClothPickUpAddress getCustPickUpAddress() {
		return custPickUpAddress;
	}

	public void setCustPickUpAddress(CustomerClothPickUpAddress custPickUpAddress) {
		this.custPickUpAddress = custPickUpAddress;
	}

	public CustomerClothDeliveryAddress getCustDeliveryAddress() {
		return custDeliveryAddress;
	}

	public void setCustDeliveryAddress(CustomerClothDeliveryAddress custDeliveryAddress) {
		this.custDeliveryAddress = custDeliveryAddress;
	}

	@Override
	public String toString() {
		return "OrderCreationDetail [id=" + id + ", quantity=" + quantity + ", pickUpDate=" + pickUpDate
				+ ", deliveryDate=" + deliveryDate + ", status=" + status + "]";
	}

}
