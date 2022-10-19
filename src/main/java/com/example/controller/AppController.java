/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author nhitr
 */

@Controller
public class AppController {
    
     @GetMapping("/")
    public String viewHomePage()
    {    
        return "index"; // returns the view name, ie the Thymele"af template "index"
    }
    
}
