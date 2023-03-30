package com.lovecalculator.SpringWebPractice.dto;

import com.lovecalculator.SpringWebPractice.error.UniqueEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {
    @NotEmpty(message = "Please enter your name")
    @UniqueEmail
    private String yourName;

    @NotBlank(message = "Please enter your crush name")
    private String crushName;
}
