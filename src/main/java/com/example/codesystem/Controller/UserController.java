package com.example.codesystem.Controller;

import com.example.codesystem.model.User;
import com.example.codesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author cc
 * @date 2022年10月30日 21:03
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;


    /*
     * @Author cc
     * @Description //TODO 登录请求 使用get和post
     * @Date 22:04 2022/11/1
 * @param null
 * @return null
     **/

    @GetMapping("/user/login")
    public String loginget(Model model){
        return "login";
    }

    @PostMapping("/user/login")
    public String loginPost(User user, Model model, HttpSession session){
        User user1 = userService.login(user);
        if(user1!=null){
            session.setAttribute("user", user1);
            return "redirect:dashboard";
        }else {
            model.addAttribute("error", "用户名错误,请重新输入");
            return "login";
        }
    }


}
