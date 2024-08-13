package com.digitaltrainee.example_hibernate.controllers;

import com.digitaltrainee.example_hibernate.models.dtos.ParamDto;
import com.digitaltrainee.example_hibernate.models.dtos.ParamixDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Default message") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamixDto bar(@RequestParam String text , @RequestParam int number) {
        ParamixDto paramixDto = new ParamixDto();
        paramixDto.setMessage(text);
        paramixDto.setCode(number);
        return paramixDto;
    }

    @GetMapping("/request")
    public ParamixDto request(@RequestParam String text , @RequestParam int number) {
        ParamixDto paramixDto = new ParamixDto();
        paramixDto.setMessage(text);
        paramixDto.setCode(number);
        return paramixDto;
    }

}
