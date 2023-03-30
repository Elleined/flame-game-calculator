package com.lovecalculator.SpringWebPractice.service;

import com.lovecalculator.SpringWebPractice.dto.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired private JavaMailSender mailSender;

    @Autowired private OTPService otpService;

    @Value("${spring.mail.username}") private String sender;


    @Override
    public void sendEmail(Email email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(sender);
            messageHelper.setTo(email.getReceiver());
            messageHelper.setSubject(email.getSubject());

            otpService.generateOtp();
            messageHelper.setText(email.getText() + "your otp pin is "  + otpService.getOtp());


            byte[] bytes = email.getAttachment().getBytes();
            String fileName = email.getAttachment().getOriginalFilename();

            ByteArrayResource resource = new ByteArrayResource(bytes);
            messageHelper.addAttachment(Objects.requireNonNull(fileName), resource);

            mailSender.send(message);
            System.out.println("Email send successfully!");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            System.out.println("Error Occurred! Sending email with attachment failed!");
        }
    }

    @Override
    public boolean isOtpValid(int otp) {
        return otpService.isOtpValid(otp);
    }
}
