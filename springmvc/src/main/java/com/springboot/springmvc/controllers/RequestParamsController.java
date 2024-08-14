package com.springboot.springmvc.controllers;

import com.springboot.springmvc.controllers.dto.ParamDto;
import com.springboot.springmvc.controllers.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo") //http://localhost:8090/api/params/foo?message=Hola
    public ParamDto foo (@RequestParam(required = false, defaultValue = "Hola que tal") String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")  //http://localhost:8090/api/params/bar?text=tuTexto&code=123
    public ParamMixDto bar (@RequestParam String text, @RequestParam Integer code){

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request") //http://localhost:8090/api/params/request?text=Hola&code=once
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 10;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e){

        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("text"));
        return params;
    }
}
