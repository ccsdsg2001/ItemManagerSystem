package com.example.codesystem.Controller;

import com.example.codesystem.model.User;
import com.example.codesystem.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Date;

/**
 * @author cc
 * @date 2022年10月30日 21:03
 */
@Controller
public class UserController {

    @Value("${spring.mail.username}")
    private String Sender;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    UserService userService;


    /*
     * @Author cc
     * @Description //TODO 登录请求 使用get和post
     * @Date 22:04 2022/11/1
 * @param null
 * @return null
 *
 *
     **/

    @GetMapping("/user/login")
    public String loginget(Model model){
        return "login";
    }

    @PostMapping("/user/login")
    public String loginPost(User user, Model model, HttpSession session, String code){
//        String kaptchaCode = session.getAttribute("verifyCode") + "";
        //验证吗模块
//        String kaptcha = (String) session.getAttribute("verifyCode");
//        if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !kaptcha.equalsIgnoreCase(code)) {
//            model.addAttribute("error", "验证码不正确!");
//            return "redirect:login";
//        }
            User user1 = userService.login(user);
        if(user1!=null){// onclick="this.src='/common/kaptcha?d='+new Date()*1"
            session.setAttribute("user", user1);
            return "redirect:dashboard";
        }else  {
            model.addAttribute("error", "用户名错误,请重新输入");
            return "redirect:login";
        }
    }


    @GetMapping("/user/register")
    //注册
    public String register(Model model){
        return "register";
    }

    @RequestMapping("/user/register1")
    public String registrPost(User user, Model model, @RequestParam("name") String userName, String password, String email){
        System.out.println("用户名"+user.getUserName());

        try {
            userService.resgisterNameIsnull(userName);
            model.addAttribute("error", "该用户已经存在!");
        } catch (Exception e) {

            userService.insert(userName,password,email);
            System.out.println("注册成功");
            model.addAttribute("error","注册成功");
            return "login";
        }
        return "register";
    }

    // 忘记密码跳转
    @GetMapping("/user/forget")
    public String forgetGet(Model model){
        return "forget";
    }

    @PostMapping("/user/forget")
    public String forgetPost(User user,Model model){
        String password = userService.selectPasswordByname(user);
        if(password==null){
            model.addAttribute("error", "账号不存在或邮箱错误!");
        }else {
            String email = user.getEmail();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(Sender);
            message.setTo(email);//接收者邮箱
            message.setSubject("密码找回");
            StringBuilder sb = new StringBuilder();
            sb.append(user.getUserName()+"用户你好,你的密码是:"+password+"感谢你的使用");
            message.setText(sb.toString());
            mailSender.send(message);
            model.addAttribute("error", "已发送到你的邮箱,请查收!");
        }
        return "forget";
    }




    @GetMapping("/user/userManage")
    public String userManagerGet(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        User user1 = userService.selectByNameAndPwd(user);
        model.addAttribute("user", user1);
        return "/user/userManage";

    }

    @PostMapping("/user/userManage")
    public String userManagerPost(Model model,User user,HttpSession session){
        Date date = new Date();
        user.setUpdateDate(date);
        int i = userService.update(user);
        session.setAttribute("user", user);
        return "redirect:userManage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        if(session.getAttribute("user")!=null){
            session.removeAttribute("user");
        }
        return "redirect:/user/login";
    }

}
