package com.lovecalculator.SpringWebPractice.service;

public interface OTPService {
    boolean isOtpValid(int otp);

    int getOtp();

    void generateOtp();
}
