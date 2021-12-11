package com.jumia.task.validation.phonenumbers.controllers;

import com.jumia.task.validation.phonenumbers.contracts.services.IValidationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/regex")
@Log4j2
public class ValidationController {

    @Autowired
    @Qualifier("ValidationService")
    IValidationService validationService;

    @GetMapping(value = "/phoneNumbers")
    public String getPhoneNumbers(Model model) {
        model.addAttribute("phones", validationService.getNumbers());
        return "all-numbers";
    }





}
