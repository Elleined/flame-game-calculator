package com.lovecalculator.SpringWebPractice;

import com.lovecalculator.SpringWebPractice.otp.OTPGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringWebPracticeApplication {
	public static void main(String[] args)	 {
//		SpringApplication.run(SpringWebPracticeApplication.class, args);
		Scanner in = new Scanner(System.in);
		OTPGenerator otpGenerator = new OTPGenerator();

		otpGenerator.generateOtp();
		int otp = otpGenerator.getOtp();
		System.out.println("OTP " + otp);
		System.out.print("Enter OTP: ");
		int userOtp = in.nextInt();
		if (otpGenerator.isExpire()) {
			otpGenerator.generateOtp();
			System.out.println("OTP expired!");
			System.out.println("New OTP " + otpGenerator.getOtp());
			return;
		}
		if (otp != userOtp) {
			System.out.println("OTP Wrong!");
			return;
		}
		System.out.println("Success");
	}
}
