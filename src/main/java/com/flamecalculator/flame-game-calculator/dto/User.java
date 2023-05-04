package com.lovecalculator.SpringWebPractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    @NotEmpty(message = "Please enter your name")
    @NotBlank(message = "Please enter your name")
    @NotNull(message = "Please enter your name")
    private String yourName;

    @NotEmpty(message = "Please enter your crush name")
    @NotBlank(message = "Please enter your crush name")
    @NotNull(message = "Please enter your crush name")
    private String crushName;
}
