package com.davisnake.apirest_jwt.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "demo")
    public String Demo(){
        
        return "Demo from public endpoint";

    }

}
