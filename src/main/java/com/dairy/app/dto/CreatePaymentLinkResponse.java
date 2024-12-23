package com.dairy.app.dto;

import java.util.Arrays;
import java.util.Map;

public class CreatePaymentLinkResponse {

	private boolean acceptPartial;
    private int amount;
    private int amountPaid;
    private String callbackMethod;
    private String callbackUrl;
    private long cancelledAt;
    private long createdAt;
    private String currency;

    private Customer customer;

    private String description;
    private long expireBy;
    private long expiredAt;
    private int firstMinPartialAmount;
    private String id;
    private Map<String, String> notes;
    private Notify notify;

    private Object payments; // Adjust type if necessary
    private String referenceId;
    private boolean reminderEnable;
    private String[] reminders;
    private String shortUrl;
    private String status;
    private long updatedAt;
    private boolean upiLink;
    private String userId;
    private boolean whatsappLink;

    // Getters and setters

    public static class Customer {
        private String contact;
        private String email;
        private String name;

        // Getters and setters
    }

    public static class Notify {
        private boolean email;
        private boolean sms;
        private boolean whatsapp;
    }

	public boolean isAcceptPartial() {
		return acceptPartial;
	}

	public void setAcceptPartial(boolean acceptPartial) {
		this.acceptPartial = acceptPartial;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getCallbackMethod() {
		return callbackMethod;
	}

	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public long getCancelledAt() {
		return cancelledAt;
	}

	public void setCancelledAt(long cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getExpireBy() {
		return expireBy;
	}

	public void setExpireBy(long expireBy) {
		this.expireBy = expireBy;
	}

	public long getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(long expiredAt) {
		this.expiredAt = expiredAt;
	}

	public int getFirstMinPartialAmount() {
		return firstMinPartialAmount;
	}

	public void setFirstMinPartialAmount(int firstMinPartialAmount) {
		this.firstMinPartialAmount = firstMinPartialAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getNotes() {
		return notes;
	}

	public void setNotes(Map<String, String> notes) {
		this.notes = notes;
	}

	public Notify getNotify() {
		return notify;
	}

	public void setNotify(Notify notify) {
		this.notify = notify;
	}

	public Object getPayments() {
		return payments;
	}

	public void setPayments(Object payments) {
		this.payments = payments;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public boolean isReminderEnable() {
		return reminderEnable;
	}

	public void setReminderEnable(boolean reminderEnable) {
		this.reminderEnable = reminderEnable;
	}

	public String[] getReminders() {
		return reminders;
	}

	public void setReminders(String[] reminders) {
		this.reminders = reminders;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isUpiLink() {
		return upiLink;
	}

	public void setUpiLink(boolean upiLink) {
		this.upiLink = upiLink;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isWhatsappLink() {
		return whatsappLink;
	}

	public void setWhatsappLink(boolean whatsappLink) {
		this.whatsappLink = whatsappLink;
	}

	@Override
	public String toString() {
		return "CreatePaymentLinkResponse [acceptPartial=" + acceptPartial + ", amount=" + amount + ", amountPaid="
				+ amountPaid + ", callbackMethod=" + callbackMethod + ", callbackUrl=" + callbackUrl + ", cancelledAt="
				+ cancelledAt + ", createdAt=" + createdAt + ", currency=" + currency + ", customer=" + customer
				+ ", description=" + description + ", expireBy=" + expireBy + ", expiredAt=" + expiredAt
				+ ", firstMinPartialAmount=" + firstMinPartialAmount + ", id=" + id + ", notify=" + notify
				+ ", payments=" + payments + ", referenceId=" + referenceId + ", reminderEnable=" + reminderEnable
				+ ", reminders=" + Arrays.toString(reminders) + ", shortUrl=" + shortUrl + ", status=" + status
				+ ", updatedAt=" + updatedAt + ", upiLink=" + upiLink + ", userId=" + userId + ", whatsappLink="
				+ whatsappLink + "]";
	}
    
    
}
