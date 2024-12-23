package com.dairy.app.response;

import java.io.Serializable;

public class RegisterOwnerResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ownerUniqueId;

	public String getOwnerUniqueId() {
		return ownerUniqueId;
	}

	public void setOwnerUniqueId(String ownerUniqueId) {
		this.ownerUniqueId = ownerUniqueId;
	}

	@Override
	public String toString() {
		return "RegisterOwnerResponseDto [ownerUniqueId=" + ownerUniqueId + "]";
	}
	
}
