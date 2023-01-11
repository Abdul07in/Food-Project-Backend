package com.food.pojo;

public class Customer {

	private Integer customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private Long customerPhone;
	private String customerPassword;

	public Customer() {

	}

	public Customer(String customerName, String customerAddress, String customerEmail, Long customerPhone,
			String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerPassword = customerPassword;
	}

	public Customer(Integer customerId, String customerName, String customerAddress, String customerEmail,
			Long customerPhone, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerPassword = customerPassword;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(Long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "\nId : " + customerId + "\nName : " + customerName + "\nAddress : "
				+ customerAddress + "\nEmail : " + customerEmail + "\nPhone : " + customerPhone;
	}

}
