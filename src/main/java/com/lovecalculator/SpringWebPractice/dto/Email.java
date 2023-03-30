package com.lovecalculator.SpringWebPractice.dto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Email {
    private String receiver;

    private String text;

    private String subject;

    private MultipartFile attachment;
}
