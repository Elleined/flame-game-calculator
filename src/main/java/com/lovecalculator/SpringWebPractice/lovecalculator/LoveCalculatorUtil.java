package com.lovecalculator.SpringWebPractice.lovecalculator;

import java.util.ArrayList;
import java.util.List;

public class LoveCalculatorUtil {
    static List<Character> toCharArray(String name) {
        List<Character> list = new ArrayList<>();
        for (char character : name.toCharArray()) {
            list.add(character);
        }
        return list;
    }
}
