package com.flamecalculator.FlameGameCalculator.flamegame;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class FlameGame {

    private String yourName;
    private String crushName;
    private String verdict;
    private final FlameGameDTO flameGameDTO = new FlameGameDTO();

    private LinkedList<Character> getMergeName() {
        List<Character> yourNameArray = FlameGameUtil.toCharArray(this.yourName);
        List<Character> crushNameArray = FlameGameUtil.toCharArray(this.crushName);

        LinkedList<Character> yourNameList = new LinkedList<>(yourNameArray);
        LinkedList<Character> crushNameList = new LinkedList<>(crushNameArray);

        LinkedList<Character> mergeLetters = new LinkedList<>();

        for (Character crushNameLetter : crushNameArray) {
            if (yourNameList.stream().anyMatch(c -> c.equals(crushNameLetter))) {
                yourNameList.remove(crushNameLetter);
                crushNameList.remove(crushNameLetter);
            }
        }
        mergeLetters.addAll(yourNameList);
        mergeLetters.addAll(crushNameList);
        flameGameDTO.setCrushNameUniqueLetters(crushNameList);
        flameGameDTO.setYourNameUniqueLetters(yourNameList);
        flameGameDTO.setMergeNameLetters(mergeLetters);
        return mergeLetters;
    }

    private int getTotalLetters() {
        int mergeNameLength = this.getMergeName().size();
        flameGameDTO.setMergeNameLength(mergeNameLength);
        return mergeNameLength;
    }

    public void displayAdditionalInfo() {
        this.flameGameDTO.displayFlameGameDTO();
    }

    private void calculateGameVerdict() {
        List<String> list = FlameGameUtil.getVerdictNameList();

        final int nameLength = this.getTotalLetters();
        int nTimesToCopy = FlameGameUtil.nTimeToCopy(nameLength);

        List<String> tripleList = FlameGameUtil.copyListByItselfNTimes(list, nTimesToCopy);

        while (list.size() != 1) {
            String removeElement = tripleList.get(nameLength - 1);

            List<String> newReference = new ArrayList<>(
                    tripleList.stream()
                            .dropWhile(s -> !s.equals(removeElement))
                            .toList());
            newReference.remove( removeElement );

            List<String> tempList = new ArrayList<>(newReference.stream()
                    .takeWhile(s -> !s.equals(removeElement))
                    .toList());

            tripleList.clear();
            FlameGameUtil.copyListNTimes(tripleList, tempList, 5);
            list.remove( removeElement );
            while (tripleList.size() <= nameLength) {
                tripleList.addAll(tempList);
            }
        }
        String verdict = list.get(0);
        this.verdict = verdict;
        flameGameDTO.setVerdict(verdict);
    }

    public String getVerdict() {
        this.calculateGameVerdict();
        return verdict;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName.replaceAll(" ", "").toUpperCase();
        flameGameDTO.setYourName(yourName);
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName.replaceAll(" ", "").toUpperCase();
        flameGameDTO.setCrushName(crushName);
    }
}
