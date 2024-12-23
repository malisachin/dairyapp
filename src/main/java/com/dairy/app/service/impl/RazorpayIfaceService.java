package com.dairy.app.service.impl;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dairy.app.constant.ApiResponse;
import com.dairy.app.dto.CreatePaymentLinkRequest;
import com.dairy.app.dto.PaymentRquestDto;
import com.dairy.app.service.iface.RazorpayIface;
import com.dairy.app.util.AppUtil;

@Service
public class RazorpayIfaceService implements RazorpayIface {

	@Value("${razorpay.key_id}")
	private String keyId;

	@Value("${razorpay.key_secret}")
	private String keySecret;

	@Value("${razorpay.base_url}")
	private String baseUrl;

	@Autowired
	private RestTemplate restTemplate;

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(keyId, keySecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	@Override
	public ApiResponse createOrder(PaymentRquestDto paymentRquestDto) {
		try {

			String url = baseUrl + "/orders";

			Map<String, Object> body = new HashMap<>();
			body.put("amount", paymentRquestDto.getAmount()); // Amount in paise
			body.put("currency", paymentRquestDto.getCurrency());
			body.put("receipt", paymentRquestDto.getReceipt());

			System.out.println("getHeaders ::" + getHeaders());
			
			HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, getHeaders());

			ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

			return AppUtil.createApiResponse(true, "Order created sucessfully", response.getBody());

		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong", null);
		}
	}

	@Override
	public ApiResponse capturePayment(PaymentRquestDto paymentRquestDto) {
		try {

			String url = baseUrl + "/payments/" + paymentRquestDto.getPaymentId() + "/capture";

			Map<String, Object> body = new HashMap<>();
			body.put("amount", paymentRquestDto.getAmount());

			HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, getHeaders());
			ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

			return AppUtil.createApiResponse(true, "Capture Payment", response.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong", null);
		}
	}

	@Override
	public ApiResponse getPaymentDetailsByPaymentId(String paymentId) {
		try {
			
			String url = baseUrl + "/payments/" + paymentId;

		    HttpEntity<Void> request = new HttpEntity<>(getHeaders());
		    ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
		    
		    if (response.getStatusCode() == HttpStatus.OK) {
		    	return AppUtil.createApiResponse(true, "Payment Details Fetched", response.getBody());
		    }else {
		    	return AppUtil.createApiResponse(false, "Payment details fetched failed", null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong", null);
		}
	}

	@Override
	public ApiResponse refundPayment(String paymentId, Integer amount) {
		try {
			String url = baseUrl + "/payments/" + paymentId + "/refund";

		    Map<String, Object> body = new HashMap<>();
		    body.put("amount", amount);

		    HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, getHeaders());
		    ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);
		    
		    System.out.println("response ::"+ response);
		    
		    if (response.getStatusCode() == HttpStatus.OK) {
		    	return AppUtil.createApiResponse(true, "Payment Refunded", response.getBody());
			}
		    return AppUtil.createApiResponse(false, "Payment Refunded Failed", null);
		    
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse createPaymentLink(CreatePaymentLinkRequest paymentLinkRequestDto) {
		try {
			
			String url = baseUrl + "/payment_links";
			
			// Prepare the request body
			JSONObject paymentLinkRequest = new JSONObject();
	        paymentLinkRequest.put("amount", paymentLinkRequestDto.getAmount());
	        paymentLinkRequest.put("currency", "INR");
	        paymentLinkRequest.put("expire_by", System.currentTimeMillis() / 1000 + 86400);  // Expiry in 24 hours
	        paymentLinkRequest.put("reference_id", paymentLinkRequestDto.getOrderId());
	        paymentLinkRequest.put("description", "Payment for order no " + paymentLinkRequestDto.getOrderId());

	        JSONObject customer = new JSONObject();
	        customer.put("name", paymentLinkRequestDto.getCustomerName());
	        customer.put("contact", paymentLinkRequestDto.getPhone());
	        customer.put("email", paymentLinkRequestDto.getEmailId());
	        paymentLinkRequest.put("customer", customer);

	        // Notes
	        JSONObject notes = new JSONObject();
	        notes.put("policy_name", "Jeevan Bima");
	        paymentLinkRequest.put("notes", notes);

	        paymentLinkRequest.put("callback_url", "http://localhost:8080/api/payment/callback");
	        paymentLinkRequest.put("callback_method", "get");
	        
	     // Prepare request entity
	        HttpEntity<String> entity = new HttpEntity<>(paymentLinkRequest.toString(), getHeaders());

	        // Make the POST request to Razorpay API
	        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	        
	        System.out.println(" responseEntity ::" + responseEntity);
	        
	        if (responseEntity.getStatusCode() == HttpStatus.OK) {
	            String responseBody = responseEntity.getBody();
	            JSONObject jsonObject = new JSONObject(responseBody);

	            // Log and return the full JSON object in the result field
	            System.out.println("Full Response: " + jsonObject.toString(4)); // Pretty print JSON

	            return AppUtil.createApiResponse(true, "Payment Link created successfully", jsonObject.toMap());
	        } else {
	            return AppUtil.createApiResponse(false, "Failed to create payment link", null);
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong", null);
		}
		
	}

	@Override
	public ApiResponse fetchOrderDetails(String orderId) {
		try {
			
			String url = baseUrl + "/orders/" + orderId;

		    HttpEntity<Void> request = new HttpEntity<>(getHeaders());
		    ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
		    if (response.getStatusCode() == HttpStatus.OK) {
		    	return AppUtil.createApiResponse(true, "Order Details Fetched", response.getBody());
			}else {
				return AppUtil.createApiResponse(false, "Order dtails fetched failed", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong", null);
		}
	}

	
	public boolean verifyPaymentSignature(String razorpayPaymentLinkId, String razorpayPaymentId, String razorpaySignature) {
        try {
            // Create payload for signature verification
            String payload = razorpayPaymentLinkId + "|" + razorpayPaymentId;
            
            System.out.println("payload ::" + payload);

            // Generate the expected signature
            String generatedSignature = generateSignature(payload);
            System.out.println("generatedSignature ::" + generatedSignature);
            // Compare the Razorpay signature with the generated signature
            return generatedSignature.equals(razorpaySignature);
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify payment signature", e);
        }
    }

    private String generateSignature(String payload) {
        try {
            // Initialize HMAC SHA256 with your Razorpay secret key
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keySecret.getBytes(), "HmacSHA256");
            sha256Hmac.init(secretKeySpec);

            // Generate the HMAC SHA256 hash
            byte[] hash = sha256Hmac.doFinal(payload.getBytes());

            // Return the base64 encoded signature
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error generating signature", e);
        }
    }
}
