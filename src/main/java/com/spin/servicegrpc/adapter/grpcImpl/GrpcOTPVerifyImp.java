package com.spin.servicegrpc.adapter.grpcImpl;

import com.spin.grpc.OTPServiceGrpc.OTPServiceImplBase;
import com.spin.grpc.OTPVerifyRequest;
import com.spin.grpc.StringUUID;
import com.spin.servicegrpc.domain.OTPVerifyDTO;
import com.spin.servicegrpc.port.in.OTPVerifyUseCase;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GrpcOTPVerifyImp extends OTPServiceImplBase {

  private final OTPVerifyUseCase otpVerifyUseCase;

  @Override
  public void verifyOTP(OTPVerifyRequest request, StreamObserver<StringUUID> responseObserver) {

    OTPVerifyDTO otpVerifyDTO = OTPVerifyDTO.builder()
        .phone(request.getPhone())
        .otpCode(request.getOtpCode())
        .deviceId(request.getDeviceId())
        .deliveryTarget(request.getDeliveryTarget())
        .build();


    StringUUID response = StringUUID.newBuilder().setUuid(
        otpVerifyUseCase.verifyOTP(otpVerifyDTO)
    ).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();


  }
}
