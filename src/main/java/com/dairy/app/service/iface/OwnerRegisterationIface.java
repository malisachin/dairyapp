package com.dairy.app.service.iface;

import com.dairy.app.constant.ApiResponse;
import com.dairy.app.dto.OwnerRegisterationDetailsDto;

public interface OwnerRegisterationIface {
	
	ApiResponse registerDairyOwner(OwnerRegisterationDetailsDto ownerRegisterationDetailsDto);

}
