package com.dairy.app.service.impl;

import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dairy.app.constant.ApiResponse;
import com.dairy.app.dto.OwnerRegisterationDetailsDto;
import com.dairy.app.exceptions.DairyExceptionAsserts;
import com.dairy.app.exceptions.DairyServiceExceptions;
import com.dairy.app.model.OwnerRegisterationDetails;
import com.dairy.app.repository.OwnerRegisterationDetailsRepository;
import com.dairy.app.response.OTPResponseDto;
import com.dairy.app.response.RegisterOwnerResponseDto;
import com.dairy.app.service.iface.OwnerRegisterationIface;
import com.dairy.app.util.AppUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OwnerRegisterationIfaceImpl implements OwnerRegisterationIface {

	@Value(value = "${ind.api.sms}")
	private String indApiSMS;

	@Autowired
	RestTemplate restTemplate;

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	OwnerRegisterationDetailsRepository ownerRegisterationDetailsRepository;

//	@Override
//	public ApiResponse registerDairyOwner(OwnerRegisterationDetailsDto ownerRegisterationDetailsDto) {
//		try {
//			OTPResponseDto otpResponseDto = new OTPResponseDto();
//			validateOwnerDeatails(ownerRegisterationDetailsDto);
//
//			if (ownerRegisterationDetailsDto.isEnableMobileOtp()) {
//				if (isValidIndianMobileNumberWithCountryCode(ownerRegisterationDetailsDto.getMobileNumber())) {
//
//					String mobileOtp = generateOtp(5);
//
//					ApiResponse apiResponseSmsOtp = sendSMSIND(mobileOtp,
//							ownerRegisterationDetailsDto.getMobileNumber().substring(3, 13),
//							ownerRegisterationDetailsDto.getFirstName());
//					if (!apiResponseSmsOtp.isSuccess()) {
//						return AppUtil.createApiResponse(false, apiResponseSmsOtp.getMessage(), null);
//					} else {
//						otpResponseDto.setMobileOTP(mobileOtp);
//						otpResponseDto.setTtl(120);
//						return AppUtil.createApiResponse(true, "Mobile otp send sucessfully", otpResponseDto);
//					}
//
//				} else {
//					throw new DairyServiceExceptions("Invalid mobile number");
//				}
//
//			} else if (ownerRegisterationDetailsDto.isEnableEmailOtp()) {
//				return null;
//			} else {
//
//				OwnerRegisterationDetails ownerRegisterationDetails = new OwnerRegisterationDetails();
//				ownerRegisterationDetails.setFirstName(ownerRegisterationDetailsDto.getFirstName());
//				ownerRegisterationDetails.setLastName(ownerRegisterationDetailsDto.getLastName());
//				ownerRegisterationDetails.setMobileNumber(ownerRegisterationDetailsDto.getMobileNumber());
//				ownerRegisterationDetails.setGender(ownerRegisterationDetailsDto.getGender());
//				ownerRegisterationDetails.setEmailId(ownerRegisterationDetailsDto.getEmailId());
//				ownerRegisterationDetails.setDateOfBirth(ownerRegisterationDetails.getDateOfBirth());
//				ownerRegisterationDetails.setAddress(ownerRegisterationDetailsDto.getAddress());
//				ownerRegisterationDetails.setOwnerPhoto(ownerRegisterationDetailsDto.getOwnerPhoto());
//				ownerRegisterationDetails.setOwnerUniqueId(AppUtil.generateUniqueId());
//
//				ownerRegisterationDetailsRepository.save(ownerRegisterationDetails);
//				otpResponseDto.setOwnerUniqueId(ownerRegisterationDetails.getOwnerUniqueId());
//
//				return AppUtil.createApiResponse(true, "Dairy owner registeration successfully", otpResponseDto);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return AppUtil.createApiResponse(false, "Something went wrong, Please try after sometime", null);
//		}
//
//	}

	public static String generateUniqueId() {
		// Generate a UUID and remove the dashes
		return UUID.randomUUID().toString().replace("-", "");
	}

	private ApiResponse sendSMSIND(String otp, String mobileNumber, String name) {
		// Prepare SMS body
		String smsBody = String.format("Dear" + name + ", %s is your Dairy Mobile verification one-time code", otp);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String smsUrlWithBody = indApiSMS + "?senderid=DGTRST&channel=Trans&DCS=0&flashsms=0&number=" + mobileNumber
				+ "&text=" + smsBody + "&route=47&peid=1301162592212041556&user=devesh.mishra@digitaltrusttech.com"
				+ "&password=DigitalTrust@20&DLTTemplateId=1307162619898313468";

		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		try {

			ResponseEntity<Object> res = restTemplate.exchange(smsUrlWithBody, HttpMethod.GET, requestEntity,
					Object.class);
			String smsResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(res.getBody());
			System.out.println("indiaSmsOtpResponse " + smsResponse);
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> indiaSmsOtpResponse = objectMapper.readValue(smsResponse,
					LinkedHashMap.class);
			if (indiaSmsOtpResponse.get("ErrorCode") == "000" || indiaSmsOtpResponse.get("ErrorCode").equals("000")) {
				return AppUtil.createApiResponse(true, indiaSmsOtpResponse.get("ErrorMessage"), null);
			} else {
				return AppUtil.createApiResponse(false, indiaSmsOtpResponse.get("ErrorMessage"), null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong, please try after sometime", null);
		}
	}

	public String generateOtp(int maxLength) {
		try {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			StringBuilder otp = new StringBuilder(maxLength);

			for (int i = 0; i < maxLength; i++) {
				otp.append(secureRandom.nextInt(9));
			}
			return otp.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isValidIndianMobileNumberWithCountryCode(String mobileNumber) {
		return mobileNumber.startsWith("+91") && mobileNumber.length() == 13;
	}

	void validateOwnerDeatails(OwnerRegisterationDetailsDto detailsDto) throws DairyServiceExceptions {
		if (detailsDto == null) {
			throw new DairyServiceExceptions("Owner Registeration Details should not be null or empty");
		}
		DairyExceptionAsserts.notNullorEmpty(detailsDto.getFirstName(), "First Name");
		DairyExceptionAsserts.notNullorEmpty(detailsDto.getLastName(), "Last Name");
		DairyExceptionAsserts.notNullorEmpty(detailsDto.getMobileNumber(), "Mobile Number");
		DairyExceptionAsserts.notNullorEmpty(detailsDto.isEnableEmailOtp(), "Enable Email OTP");
		DairyExceptionAsserts.notNullorEmpty(detailsDto.isEnableMobileOtp(), "Enable Mobile OTP");

	}

	@Override
	public ApiResponse registerDairyOwner(OwnerRegisterationDetailsDto ownerRegisterationDetailsDto) {
		try {
			RegisterOwnerResponseDto ownerResponseDto = new RegisterOwnerResponseDto();
			if (ownerRegisterationDetailsDto != null) {
				OwnerRegisterationDetails ownerRegisterationDetails = new OwnerRegisterationDetails();
				ownerRegisterationDetails.setFirstName(ownerRegisterationDetailsDto.getFirstName());
				ownerRegisterationDetails.setLastName(ownerRegisterationDetailsDto.getLastName());
				ownerRegisterationDetails.setMobileNumber(ownerRegisterationDetailsDto.getMobileNumber());
				ownerRegisterationDetails.setGender(ownerRegisterationDetailsDto.getGender());
				ownerRegisterationDetails.setEmailId(ownerRegisterationDetailsDto.getEmailId());
				ownerRegisterationDetails.setDateOfBirth(ownerRegisterationDetails.getDateOfBirth());
				ownerRegisterationDetails.setAddress(ownerRegisterationDetailsDto.getAddress());
				ownerRegisterationDetails.setOwnerPhoto(ownerRegisterationDetailsDto.getOwnerPhoto());
				ownerRegisterationDetails.setOwnerUniqueId(AppUtil.generateUniqueId());

				ownerRegisterationDetailsRepository.save(ownerRegisterationDetails);
				ownerResponseDto.setOwnerUniqueId(ownerRegisterationDetails.getOwnerUniqueId());
				return AppUtil.createApiResponse(true, "Owner registeration sucessfully", ownerResponseDto);
			}else {
				return AppUtil.createApiResponse(false, "Invalid request", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return AppUtil.createApiResponse(false, "Something went wrong, Please try letter", null);
		}
		
	}

}
