package com.flamecalculator.FlameGameCalculator.controller;

import com.flamecalculator.FlameGameCalculator.dto.User;
import com.flamecalculator.FlameGameCalculator.service.FlameService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FlameController {

    private final FlameService flameService;

    public FlameController(FlameService flameService) {
        this.flameService = flameService;
    }

    @GetMapping
    public String goToIndex(@ModelAttribute User user) {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@Valid @ModelAttribute User user,
                            BindingResult result,
                            Model model) {

        if (result.hasErrors()) return "index";
        if (flameService.isNameSameLength(user)) {
            model.addAttribute("isSameLength", true);
            model.addAttribute("sameLengthErrorMessage", "Please enter two different names between 2 and 100 characters long!");
            return "index";
        }
        String verdictName = flameService.getVerdictName( user );
        System.out.println(verdictName);
        String verdictImage = flameService.getVerdictImage( verdictName );
        model.addAttribute("verdictImage", verdictImage);
        model.addAttribute("verdictName", verdictName);
        flameService.displayAdditionalInfo();
        return "result";
    }

}
