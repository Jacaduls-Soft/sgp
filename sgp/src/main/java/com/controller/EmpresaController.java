package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {
    @GetMapping("/")
    public String EmpresaCont(){
        return "Control empresa";
    }
}
