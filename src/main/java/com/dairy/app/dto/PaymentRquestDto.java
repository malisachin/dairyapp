package com.dairy.app.dto;

import java.io.Serializable;

public class PaymentRquestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int amount;
	private String currency; 
	private String receipt;
	private String paymentId;
	private String payeeName;
	private String emailId;
	private String mobileNo;
	private String callback_url;
	private String callback_method;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getCallback_url() {
		return callback_url;
	}
	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}
	public String getCallback_method() {
		return callback_method;
	}
	public void setCallback_method(String callback_method) {
		this.callback_method = callback_method;
	}
	@Override
	public String toString() {
		return "PaymentRquestDto [amount=" + amount + ", currency=" + currency + ", receipt=" + receipt + ", paymentId="
				+ paymentId + ", payeeName=" + payeeName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", callback_url=" + callback_url + ", callback_method=" + callback_method + "]";
	}
	
	
	
}
