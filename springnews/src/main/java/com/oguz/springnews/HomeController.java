
package com.oguz.springnews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String home() {
        System.out.println("hello");
        return "home.xhtml";
    }
    
}
