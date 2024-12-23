package com.dairy.app.service.iface;

import com.dairy.app.constant.ApiResponse;
import com.dairy.app.dto.CreatePaymentLinkRequest;
import com.dairy.app.dto.PaymentRquestDto;
import com.dairy.app.util.AppUtil;

public interface RazorpayIface {

	
	ApiResponse createOrder(PaymentRquestDto paymentRquestDto);
	
	ApiResponse fetchOrderDetails(String orderId);
	
	ApiResponse capturePayment(PaymentRquestDto paymentRquestDto);
	
	ApiResponse createPaymentLink(CreatePaymentLinkRequest dto);
	
	ApiResponse getPaymentDetailsByPaymentId(String paymentId);
	
	ApiResponse refundPayment(String paymentId, Integer amount);
	
	boolean verifyPaymentSignature(String razorpayPaymentLinkId, String razorpayPaymentId, String razorpaySignature);
	
	default ApiResponse getServiceStatus() {
		
		return AppUtil.createApiResponse(true, "Started", null);
	}
	
	static ApiResponse getServiceStatusFromStatic() {
		return AppUtil.createApiResponse(true, "Started static ", null);
	}
}
