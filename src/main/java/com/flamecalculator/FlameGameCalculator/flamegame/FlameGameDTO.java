package com.flamecalculator.FlameGameCalculator.flamegame;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Data
public class FlameGameDTO {
    private String yourName;
    private String crushName;
    private String verdict;
    private List<Character> yourNameUniqueLetters;
    private List<Character> crushNameUniqueLetters;
    private int mergeNameLength;
    private List<Character> mergeNameLetters;

    public void displayFlameGameDTO() {
        System.out.println("Your name: " + yourName);
        System.out.println("Crush name: " + crushName);

        StringJoiner yourNameJoiner = new StringJoiner(", ");
        yourNameUniqueLetters.stream()
                .map(Objects::toString)
                .forEach(yourNameJoiner::add);
        System.out.println("Your name unique letters: " + yourNameJoiner);

        StringJoiner crushNameJoiner = new StringJoiner(", ");
        crushNameUniqueLetters.stream()
                .map(Objects::toString)
                .forEach(crushNameJoiner::add);
        System.out.println("Crush name unique letters: " + crushNameJoiner);

        StringJoiner mergeNameJoiner = new StringJoiner(", ");
        mergeNameLetters.stream()
                .map(Objects::toString)
                .forEach(mergeNameJoiner::add);
        System.out.println("Your name unique letters: " + mergeNameJoiner);

        System.out.println("Total merge name length: " + mergeNameLength);

        System.out.println("Game verdict: " + verdict);
    }
}
