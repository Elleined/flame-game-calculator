package com.lovecalculator.SpringWebPractice.service;

import com.lovecalculator.SpringWebPractice.dto.Email;

public interface EmailService {
    void sendEmail(Email email);
    boolean isOtpValid(int otp);
}
