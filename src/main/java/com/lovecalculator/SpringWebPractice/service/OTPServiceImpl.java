package com.lovecalculator.SpringWebPractice.service;

import com.lovecalculator.SpringWebPractice.otp.OTPGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OTPServiceImpl implements OTPService {

    private final OTPGenerator otpGenerator;

    @Autowired
    public OTPServiceImpl(OTPGenerator otpGenerator) {
        this.otpGenerator = otpGenerator;
    }

    @Override
    public boolean isOtpValid(int otp) {
        int generatedOtp = otpGenerator.getOtp();
        if (otp != generatedOtp) {
            System.out.println("OTP not match!");
            return true;
        }
        if (otpGenerator.isExpire()) {
            System.out.println("OTP expired");
            return true;
        }
        System.out.println("OTP Validated!");
        return false;
    }

    @Autowired
    public int getOtp() {
        return otpGenerator.getOtp();
    }

    @Override
    public void generateOtp() {
        otpGenerator.generateOtp();
    }
}
