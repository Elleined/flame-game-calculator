package com.lovecalculator.SpringWebPractice.controller;

import com.lovecalculator.SpringWebPractice.dto.User;
import com.lovecalculator.SpringWebPractice.service.FlameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping
public class FlameController {

    @Autowired
    private FlameService flameService;

    @GetMapping
    public String goToIndex(@ModelAttribute User user) {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@Valid @ModelAttribute User user,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {

            String warningMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            model.addAttribute("modalTitle", "Warning");
            model.addAttribute("modalMessage", warningMessage);
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
