package com.lovecalculator.SpringWebPractice.otp;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class OTPGenerator {
    private final Set<Integer> otpList = new HashSet<>();
    private LocalDateTime ldt;

    private int otp;

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(ldt);
    }

    public int getOtp() {
        return this.otp;
    }

    public void generateOtp() {
        this.otp = new Random().nextInt(100_000, 999_999);
        if (otpList.contains(this.otp)) generateOtp();
        otpList.add(otp);
        ldt = LocalDateTime.now().plusSeconds(60);
    }
}
