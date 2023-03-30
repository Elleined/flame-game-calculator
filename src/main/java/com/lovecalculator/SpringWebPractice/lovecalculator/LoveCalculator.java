package com.lovecalculator.SpringWebPractice.lovecalculator;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LoveCalculator {

    private String yourName;
    private String crushName;

    public LinkedList<Integer> countName() {
        List<Character> yourNameArray = LoveCalculatorUtil.toCharArray(this.yourName);
        List<Character> crushNameArray = LoveCalculatorUtil.toCharArray(this.crushName);

        Set<Character> yourNameList = new HashSet<>(yourNameArray);
        Set<Character> crushNameList = new HashSet<>(crushNameArray);

        List<Character> mergeNameList = new ArrayList<>();
        mergeNameList.addAll(yourNameArray);
        mergeNameList.addAll(crushNameArray);

        LinkedList<Integer> listCounter = new LinkedList<>();

        Iterator<Character> crushLetters = crushNameList.iterator();
        Iterator<Character> yourLetters = yourNameList.iterator();
        while (yourLetters.hasNext() && crushLetters.hasNext()) {
            Character yourLetter = yourLetters.next();
            Character crushLetter = crushLetters.next();
            if (yourLetter.equals(crushLetter)) {
                int letterCount = (int) mergeNameList.stream()
                        .filter(crushLetter::equals)
                        .count();
                listCounter.add(letterCount);
            } else {
                listCounter.add(1);
            }
        }

        return listCounter;
    }

    private LinkedList<Integer> calculateLovePercentage(LinkedList<Integer> list) {
        LinkedList<Integer> sumList = new LinkedList<>();
        while (!list.isEmpty()) {
            int leftMostElement = list.pollFirst();
            int rightMostElement = list.pollLast();
            if (list.size() == 1) list.offer(0);

            int sum = leftMostElement + rightMostElement;
            if (sum >= 10) {
                int firstNumber = getSeparatedNumber(sum, 1);
                int secondNumber = getSeparatedNumber(sum, 2);
                sumList.add(firstNumber);
                sumList.add(secondNumber);
                continue;
            }
            sumList.add(sum);
        }
        if (sumList.size() != 2) return calculateLovePercentage(sumList);
        return sumList;
    }

    private static int getSeparatedNumber(int target, int location) {
        String targetToString = String.valueOf(target);
        List<Character> separatedNumbers = LoveCalculatorUtil.toCharArray(targetToString);
        if (location > separatedNumbers.size()) throw new IllegalArgumentException();
        return Integer.parseInt(separatedNumbers.get(location - 1).toString());
    }

    public int getLovePercentage(LinkedList<Integer> list) {
        String lovePercentage = this.calculateLovePercentage(list).stream()
                .map(String::valueOf)
                .reduce("", (t, s) -> t + s);
        return Integer.parseInt(lovePercentage);
    }

    public void setYourName(String yourName) {
        this.yourName = yourName.replaceAll(" ", " ").toUpperCase();
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName.replaceAll(" ", " ").toUpperCase();
    }
}