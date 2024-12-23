package com.dairy.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.app.constant.ApiResponse;
import com.dairy.app.dto.CreatePaymentLinkRequest;
import com.dairy.app.dto.PaymentRquestDto;
import com.dairy.app.service.iface.RazorpayIface;
import com.dairy.app.util.AppUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Razorpay Controller", description = "Handles all payment-related operations through Razorpay")
public class RazorpayController {

	@Autowired
	private RazorpayIface razorpayIface;

	@PostMapping("/api/payment/order")
	@Operation(summary = "Create an order", description = "Creates a Razorpay order using the provided details")
	public ApiResponse createOrder(@RequestBody PaymentRquestDto paymentRquestDto) {
		return razorpayIface.createOrder(paymentRquestDto);
	}

	@GetMapping("/api/get/order/details")
	@Operation(summary = "Fetch order details", description = "Fetches the details of a Razorpay order based on the provided order ID")
	public ApiResponse fetchOrderDetails(@RequestParam("orderId") String orderId) {
		return razorpayIface.fetchOrderDetails(orderId);
	}

	@PostMapping("/api/payment/capture")
	@Operation(summary = "Capture payment", description = "Captures payment for the provided order ID")
	public ApiResponse capturePayment(@RequestBody PaymentRquestDto paymentRquestDto) {
		return razorpayIface.capturePayment(paymentRquestDto);
	}

	@GetMapping("/api/get/payment/details")
	@Operation(summary = "Fetch payment details", description = "Fetches payment details based on payment ID")
	public ApiResponse getPaymentDetails(@RequestParam("paymentId") String paymentId) {
		return razorpayIface.getPaymentDetailsByPaymentId(paymentId);
	}

	@GetMapping("/api/get/refund")
	@Operation(summary = "Fetch payment refund details", description = "Fetches refund details for the given payment ID")
	public ApiResponse getPaymentRefund(@RequestParam("paymentId") String paymentId,
			@RequestParam("amount") Integer amount) {
		return razorpayIface.refundPayment(paymentId, amount);
	}

	@PostMapping("/api/create/payment/link")
	@Operation(summary = "Create a payment link", description = "Creates a Razorpay payment link using the provided request details")
	public ApiResponse createPayemntLink(@RequestBody CreatePaymentLinkRequest createPaymentLinkRequest) {
		return razorpayIface.createPaymentLink(createPaymentLinkRequest);
	}

	// Handle the payment callback from Razorpay
	@GetMapping("/api/payment/callback")
	@Operation(summary = "Handle payment callback", description = "Handles the callback from Razorpay after a payment is made")
	public ResponseEntity<ApiResponse> handlePaymentCallback(@RequestParam Map<String, String> queryParams) {
		try {
			// Log or process the callback parameters received from Razorpay
			System.out.println("Callback received with parameters: " + queryParams);

			// Extract parameters from Razorpay callback
			String razorpayPaymentId = queryParams.get("razorpay_payment_id");
			String razorpayPaymentLinkId = queryParams.get("razorpay_payment_link_id");
			String razorpayPaymentLinkStatus = queryParams.get("razorpay_payment_link_status");
			String razorpaySignature = queryParams.get("razorpay_signature");
			// Verify the signature

			System.out.println(" razorpayPaymentId ::" + razorpayPaymentId);
			System.out.println(" razorpayPaymentLinkId ::" + razorpayPaymentLinkId);
			System.out.println(" razorpayPaymentLinkStatus ::" + razorpayPaymentLinkStatus);
			System.out.println(" razorpaySignature ::" + razorpaySignature);

			if ("paid".equalsIgnoreCase(razorpayPaymentLinkStatus)) {
				boolean isValidSignature = razorpayIface.verifyPaymentSignature(razorpayPaymentLinkId,
						razorpayPaymentId, razorpaySignature);

				if (isValidSignature) {
					// Proceed with further logic after successful verification
					return ResponseEntity.ok(AppUtil.createApiResponse(true, "Payment Verified Successfully", null));
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(AppUtil.createApiResponse(false, "Invalid Payment Signature", null));
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(AppUtil.createApiResponse(false, "Payment not successful", null));
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(AppUtil.createApiResponse(false, "Error processing the payment callback", e.getMessage()));
		}
	}
	
	@GetMapping("/api/get/servvice/status")
	public ApiResponse getServiceStatus() {
		//return razorpayIface.getServiceStatus();
		return RazorpayIface.getServiceStatusFromStatic();
	}
}
