package com.itheima.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/quick")
    private String save(){
        System.out.println("save ...");
        return "success.jsp";
    }
}
