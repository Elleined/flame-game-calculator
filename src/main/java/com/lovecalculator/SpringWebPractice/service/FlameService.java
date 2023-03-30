package com.lovecalculator.SpringWebPractice.service;

import com.lovecalculator.SpringWebPractice.dto.User;

public interface FlameService {
    String getVerdictName(User user);

    String getVerdictImage(String verdict);

    void displayAdditionalInfo();
}
