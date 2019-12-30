package com.itheima.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * ModelAndView
 */
@Controller
public class UserController {
    @RequestMapping("/quick13")
    @ResponseBody
    private void quick13(String[] strs) throws IOException {
        System.out.println("user is " + Arrays.asList(strs));
    }

    @RequestMapping("/quick12")
    @ResponseBody
    private void quick12(User user) throws IOException {
        System.out.println("user is " + user.toString());
    }

    @RequestMapping("/quick11")
    @ResponseBody
    private void quick11(String username,int age) throws IOException {
        System.out.println("username is " + username);
        System.out.println("age is " + age);

    }

    @RequestMapping("/quick10")
    @ResponseBody
    private User quick10() throws IOException {
        User user = new User();
        user.setUsername("simon");
        user.setAge(18);
        return user;
    }

    @RequestMapping("/quick8")
    @ResponseBody
    private String quick8() throws IOException {
        User user = new User();
        user.setUsername("simon");
        user.setAge(18);

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(user);
        return value;
    }

    @RequestMapping("/quick7")
    @ResponseBody
    private String quick7() throws IOException {
        return "hello,itcast7!";
    }

    @RequestMapping("/quick6")
    private void quick6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,itcast!");
    }


    //ModelAndView


    @RequestMapping("/quick5")
    private String quick5(HttpServletRequest request) {
        request.setAttribute("username", "博学谷");
        return "success";
    }

    @RequestMapping("/quick4")
    private String quick4(Model model) {
        model.addAttribute("username", "博学谷");
        return "success";
    }

    @RequestMapping("/quick3")
    private ModelAndView quick3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    private ModelAndView quick2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "itcast");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick")
    private String quick() {
        System.out.println("save ...");
        return "success";
//        return UrlBasedViewResolver.REDIRECT_URL_PREFIX+ "/jsp/success.jsp";
    }
}
