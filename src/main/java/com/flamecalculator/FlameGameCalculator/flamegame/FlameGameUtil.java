package com.flamecalculator.FlameGameCalculator.flamegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface FlameGameUtil {

    static List<String> getVerdictNameList() {
        List<String> list = new ArrayList<>();
        for (Verdict verdict : Verdict.values()) {
            list.add(verdict.name());
        }
        return list;
    }

    static List<Character> toCharArray(String name) {
        List<Character> list = new ArrayList<>();
        for (char character : name.toCharArray()) {
            list.add(character);
        }
        return list;
    }

    static List<String> getVerdictImageList() {
        return Arrays.asList(
                "/friends.gif",
                "/lover.gif",
                "/affection.gif",
                "/marriage.gif",
                "/enemy.gif",
                "/sister.gif"
        );
    }

    static  <T> List<T> copyListByItselfNTimes(List<T> list, int times) {
        if (times > 10 || times == 0) throw new IllegalArgumentException();
        List<T> tempList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            tempList.addAll(list);
        }
        return tempList;
    }

    static  <T, S extends T> void copyListNTimes(List<T> targetList, List<S > listToCopy, int times) {
        if (times > 10 || times == 0) throw new IllegalArgumentException();
        for (int i = 0; i < times; i++) {
            targetList.addAll(listToCopy);
        }
    }

    static int nTimeToCopy(int nameLength) {
        int counter = 0;
        while (nameLength > 0) {
            if (nameLength % 6 == 0) counter++;
            nameLength--;
        }
        return counter + 1;
    }
}
