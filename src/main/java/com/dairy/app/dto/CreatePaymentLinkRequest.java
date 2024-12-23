package com.dairy.app.dto;

public class CreatePaymentLinkRequest {

	private Integer amount;
	private String orderId;
	private String customerName;
	private String phone;
	private String emailId;

	// Getters and Setters

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "CreatePaymentLinkRequest [amount=" + amount + ", orderId=" + orderId + ", customerName=" + customerName
				+ ", phone=" + phone + ", emailId=" + emailId + "]";
	}

}
