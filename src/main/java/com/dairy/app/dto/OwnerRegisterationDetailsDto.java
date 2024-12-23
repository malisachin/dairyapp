package com.dairy.app.dto;

import java.io.Serializable;

public class OwnerRegisterationDetailsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNumber;
	
	private String ownerUniqueId;
	
	private String address;
	
	private String userName;
	
	private String passwoard;
	
	private String pincode;
	
	private String gender;
	
	private String dateOfBirth;
	
	private String taluka;
	
	private String district;
	
	private String state;
	
	private String status;
	
	private String ownerPhoto;
	
	private boolean enableMobileOtp;
	
	private boolean enableEmailOtp;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOwnerUniqueId() {
		return ownerUniqueId;
	}

	public void setOwnerUniqueId(String ownerUniqueId) {
		this.ownerUniqueId = ownerUniqueId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswoard() {
		return passwoard;
	}

	public void setPasswoard(String passwoard) {
		this.passwoard = passwoard;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwnerPhoto() {
		return ownerPhoto;
	}

	public void setOwnerPhoto(String ownerPhoto) {
		this.ownerPhoto = ownerPhoto;
	}

	public boolean isEnableMobileOtp() {
		return enableMobileOtp;
	}

	public void setEnableMobileOtp(boolean enableMobileOtp) {
		this.enableMobileOtp = enableMobileOtp;
	}

	public boolean isEnableEmailOtp() {
		return enableEmailOtp;
	}

	public void setEnableEmailOtp(boolean enableEmailOtp) {
		this.enableEmailOtp = enableEmailOtp;
	}
	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "OwnerRegisterationDetailsDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", ownerUniqueId=" + ownerUniqueId + ", address="
				+ address + ", userName=" + userName + ", passwoard=" + passwoard + ", pincode=" + pincode + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", taluka=" + taluka + ", district=" + district + ", state="
				+ state + ", status=" + status + ", ownerPhoto=" + ownerPhoto + ", enableMobileOtp=" + enableMobileOtp
				+ ", enableEmailOtp=" + enableEmailOtp + "]";
	}
	
}
