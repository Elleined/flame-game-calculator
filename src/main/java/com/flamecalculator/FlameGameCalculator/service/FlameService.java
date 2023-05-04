package com.flamecalculator.FlameGameCalculator.service;

import com.flamecalculator.FlameGameCalculator.flamegame.FlameGame;
import com.flamecalculator.FlameGameCalculator.flamegame.FlameGameUtil;
import com.flamecalculator.FlameGameCalculator.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class FlameService {

    @Autowired
    private FlameGame flameGame;

    public String getVerdictName(User user) {
        flameGame.setYourName(user.getYourName());
        flameGame.setCrushName(user.getCrushName());

        return flameGame.getVerdict();
    }

    public boolean isNameSameLength(User user) {
        return user.getYourName().length() == user.getCrushName().length();
    }

    public String getVerdictImage(String verdict) {
        HashMap<String, String> map = new HashMap<>();
        List<String> verdictNames = FlameGameUtil.getVerdictNameList();
        List<String> verdictImages = FlameGameUtil.getVerdictImageList();

        Iterator<String> nameItr = verdictNames.iterator();
        Iterator<String> imageItr = verdictImages.iterator();
        while (nameItr.hasNext() && imageItr.hasNext()) {
            map.put(nameItr.next(), imageItr.next());
        }
        return map.get( verdict );
    }

    public void displayAdditionalInfo() {
        flameGame.displayAdditionalInfo();
    }
}
