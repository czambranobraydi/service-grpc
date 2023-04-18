package com.spin.servicegrpc.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OTPVerifyDTO {
  String phone;
  String otpCode;
  String deviceId;
  String deliveryTarget;
}
