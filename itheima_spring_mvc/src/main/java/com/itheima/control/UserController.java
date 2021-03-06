package com.itheima.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * ModelAndView
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/quick23")
    @ResponseBody
    private void quick23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            File file = new File("/Users/simon/Downloads/" + originalFilename);
            multipartFile.transferTo(file);
        }
    }

    @RequestMapping("/quick22")
    @ResponseBody
    private void quick22(String username, MultipartFile uploadFile, MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        String originalFilename = uploadFile.getOriginalFilename();
        File file = new File("/Users/simon/Downloads/" + originalFilename);
        uploadFile.transferTo(file);

        String originalFilename2 = uploadFile2.getOriginalFilename();
        File file2 = new File("/Users/simon/Downloads/" + originalFilename2);
        uploadFile2.transferTo(file2);
    }

    @RequestMapping("/quick21")
    @ResponseBody
    private void quick21(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) throws IOException {
        System.out.println(jsessionId);
    }

    @RequestMapping("/quick20")
    @ResponseBody
    private void quick20(@RequestHeader(value = "User-Agent", required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    @RequestMapping("/quick19")
    @ResponseBody
    private void quick19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick18")
    @ResponseBody
    private void quick18(Date date) throws IOException {
        System.out.println(date);
    }

    //Restful风格
    @RequestMapping("/quick17/{username}")
    @ResponseBody
    private void quick17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println("user is " + username);
    }

    @RequestMapping("/quick16")
    @ResponseBody
    private void quick16(@RequestParam(value = "name", required = false, defaultValue = "itcast") String username) throws IOException {
        System.out.println("user is " + username);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    private void quick15(@RequestBody List<User> userList) throws IOException {
        System.out.println("userList is " + userList);
    }

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
    private void quick11(String username, int age) throws IOException {
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

    @RequestMapping(value = "/quick")
    private String quick() {
        System.out.println("save ...");
        return "success";
//        return UrlBasedViewResolver.REDIRECT_URL_PREFIX+ "/jsp/success.jsp";
    }
}
