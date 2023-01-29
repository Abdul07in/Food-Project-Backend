package com.food.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {

	private Integer orderId;
	private Double billingAmount;
	private LocalDate orderDate;
	private String customerEmail;
	private String dropLocation;
	private LocalDateTime deliveryDate;
	private String orderStatus;

	public Order() {

	}

	public Order(Double billingAmount, LocalDate orderDate, String customerEmail, String dropLocation,
			LocalDateTime deliveryDate, String orderStatus) {
		super();
		this.billingAmount = billingAmount;
		this.orderDate = orderDate;
		this.customerEmail = customerEmail;
		this.dropLocation = dropLocation;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
	}

	public Order(Integer orderId, Double billingAmount, LocalDate orderDate, String customerEmail, String dropLocation,
			LocalDateTime deliveryDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.billingAmount = billingAmount;
		this.orderDate = orderDate;
		this.customerEmail = customerEmail;
		this.dropLocation = dropLocation;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", billingAmount=" + billingAmount + ", orderDate=" + orderDate
				+ ", customerEmail=" + customerEmail + ", dropLocation=" + dropLocation + ", deliveryDate="
				+ deliveryDate + ", orderStatus=" + orderStatus + "]";
	}

}