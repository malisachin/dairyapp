package com.dairy.app.model;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner_registeration_details")
@NamedQuery(name = "OwnerRegisterationDetails.findAll",query = "SELECT o FROM OwnerRegisterationDetails o")
public class OwnerRegisterationDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "owner_id")
	private int ownerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "owner_unique_id")
	private String ownerUniqueId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "passwoard")
	private String passwoard;
	
	@Column(name = "pincode")
	private String pincode;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "owner_photo")
	private String ownerPhoto;
	
	@Column(name = "enable_mobile_otp")
	private boolean enableMobileOtp;
	
	@Column(name = "enable_email_otp")
	private boolean enableEmailOtp;

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

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
		return "OwnerRegisterationDetails [ownerId=" + ownerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", ownerUniqueId=" + ownerUniqueId
				+ ", address=" + address + ", userName=" + userName + ", passwoard=" + passwoard + ", pincode="
				+ pincode + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", taluka=" + taluka + ", district="
				+ district + ", state=" + state + ", status=" + status + ", ownerPhoto=" + ownerPhoto
				+ ", enableMobileOtp=" + enableMobileOtp + ", enableEmailOtp=" + enableEmailOtp + "]";
	}

}
