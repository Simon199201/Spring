package com.itheima.control;

import com.itheima.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionTest {
    @RequestMapping("/show1")
    public void show1() throws ClassCastException{
        String str = "";
        int num = Integer.parseInt(str);
    }
    @RequestMapping("/show2")
    public void show2() throws MyException {
        String str = "";
        throw  new MyException();
    }
}
