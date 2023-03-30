package com.lovecalculator.SpringWebPractice.lovecalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.plaf.SliderUI;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LoveCalculatorTest {

    @Test
    void getLovePercentage() {
        LoveCalculator loveCalculator = new LoveCalculator();

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 9, 5, 6, 2));
        int lovePercentage = loveCalculator.getLovePercentage(list);
        System.out.println(lovePercentage);
    }

    @Test
    void nameCounter() {
        LoveCalculator loveCalculator = new LoveCalculator();
        loveCalculator.setYourName("Denielle");
        loveCalculator.setCrushName("Lj");
        LinkedList<Integer> numList = loveCalculator.countName();
        numList.forEach(System.out::println);
    }
}