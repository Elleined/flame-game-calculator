package com.lovecalculator.SpringWebPractice.flamegame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FlameGameTest {
    @Test
    public void verdictAlgo() {
        List<String> list = FlameGameUtil.getVerdictNameList();

        final int nameLength = 20;
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
            FlameGameUtil.copyListNTimes(tripleList, tempList, 3);
            list.remove( removeElement );
            while (tripleList.size() < nameLength) {
                tripleList.addAll(tempList);
            }
        }
        System.out.println(list.get(0));
    }


    @Test
    public void howManyTimesToCopy() {
        int counter = 0;
        int num = 23;
        while (num > 0) {
            if (num % 6 == 0) counter++;
            num--;
        }
        System.out.println(counter + 1);
    }

    @Test
    public void displayFlameGameDTO() {
        FlameGame flameGame = new FlameGame();
        flameGame.setYourName("Denielle");
        flameGame.setCrushName("Peryong");
        flameGame.getVerdict();
        flameGame.displayAdditionalInfo();
    }
}