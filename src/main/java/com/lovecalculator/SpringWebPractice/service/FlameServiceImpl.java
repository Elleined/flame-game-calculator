package com.lovecalculator.SpringWebPractice.service;

import com.lovecalculator.SpringWebPractice.dto.User;
import com.lovecalculator.SpringWebPractice.flamegame.FlameGame;
import com.lovecalculator.SpringWebPractice.flamegame.FlameGameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class FlameServiceImpl implements FlameService {

    @Autowired
    private FlameGame flameGame;

    @Override
    public String getVerdictName(User user) {
        flameGame.setYourName(user.getYourName());
        flameGame.setCrushName(user.getCrushName());

        return flameGame.getVerdict();
    }

    @Override
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

    @Override
    public void displayAdditionalInfo() {
        flameGame.displayAdditionalInfo();
    }
}
