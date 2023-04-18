package com.spin.servicegrpc.service;

import com.spin.servicegrpc.domain.OTPVerifyDTO;
import com.spin.servicegrpc.port.in.OTPVerifyUseCase;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OTPVerifyService implements OTPVerifyUseCase {

  @Override
  public String verifyOTP(OTPVerifyDTO otpVerifyDTO) {
    return UUID.randomUUID().toString();
  }
}
