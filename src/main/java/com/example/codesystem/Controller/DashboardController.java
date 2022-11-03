package com.example.codesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cc
 * @date 2022年11月03日 22:02
 */
@Controller
public class DashboardController {



    @GetMapping("/user/dashboard")
    public String  dashboardGet(Model model){
        return "dashboard";
    }



}
