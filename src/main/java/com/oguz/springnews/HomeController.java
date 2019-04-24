/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oguz.springnews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author oguz
 */
@Controller
public class HomeController {
    
    @RequestMapping("home")
    @ResponseBody
    public String home() {
        System.out.println("hello");
        return "home.xhtml";
    }
    
}
