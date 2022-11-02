package com.example.codesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cc
 * @date 2022年10月20日 21:05
 */

@Controller
public class indexController {



    @GetMapping("/")
    public String login(){
        return "redirect:/user/login";
    }



    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/re")
    public String register(){
        return "register";
    }


}
