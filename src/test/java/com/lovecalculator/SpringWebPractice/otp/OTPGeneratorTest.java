package com.lovecalculator.SpringWebPractice.otp;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class OTPGeneratorTest {

    @Test
    void generateOtpTry() {
        Scanner in = new Scanner(System.in);
        OTPGenerator otpGenerator = new OTPGenerator();

        otpGenerator.generateOtp();
        int otp = otpGenerator.getOtp();
        System.out.println("OTP " + otp);
        System.out.print("Enter OTP: ");
        int userOtp = in.nextInt();
        if (otpGenerator.isExpire()) {
            System.out.println("OTP expired!");
//            otpGenerator.generateOtp();
//            System.out.println("New OTP " + otpGenerator.getOtp());
            return;
        }
        if (otp != userOtp) {
            System.out.println("OTP Wrong!");
            return;
        }
        System.out.println("Success");
    }
}