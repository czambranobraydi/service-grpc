package com.spin.servicegrpc.port.in;

import com.spin.servicegrpc.domain.OTPVerifyDTO;

public interface OTPVerifyUseCase {

  String verifyOTP(OTPVerifyDTO otpVerifyDTO);

}
