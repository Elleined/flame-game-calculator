package com.lovecalculator.SpringWebPractice.controller;

import com.lovecalculator.SpringWebPractice.dto.Email;
import com.lovecalculator.SpringWebPractice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String goToEmailPage(@ModelAttribute Email email) {
        return "email";
    }

    @PostMapping("/send")
    public String sendEmail(@ModelAttribute Email email) {
        emailService.sendEmail(email);
        return "otp";
    }

    @PostMapping("/otp")
    public String validateOtp(@RequestParam int otp) {
        if (!emailService.isOtpValid(otp)) {
            return "otp";
        }
        return "redirect:/email";
    }
}
