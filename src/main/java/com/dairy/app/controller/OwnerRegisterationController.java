package com.dairy.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.app.constant.ApiResponse;
import com.dairy.app.dto.OwnerRegisterationDetailsDto;
import com.dairy.app.service.iface.OwnerRegisterationIface;
import com.dairy.app.util.AppUtil;

@RestController
@RequestMapping("/api/")
public class OwnerRegisterationController {

	@Autowired
	OwnerRegisterationIface ownerRegisterationIface;

//	@PostMapping("register/owner")
//	public ApiResponse registerDairyOwner(@RequestBody OwnerRegisterationDetailsDto detailsDto) {
//		return ownerRegisterationIface.registerDairyOwner(detailsDto);
//	}
	
	@GetMapping("get/status")
	public ApiResponse getServiceStatus() {
		return AppUtil.createApiResponse(true, "Service is up", null);
	}
	
	
	@PostMapping("owners/register")
	public ApiResponse registerOwner(@RequestBody OwnerRegisterationDetailsDto detailsDto) {
		return ownerRegisterationIface.registerDairyOwner(detailsDto);
	}
	
}
