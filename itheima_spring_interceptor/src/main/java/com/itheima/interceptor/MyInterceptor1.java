package com.itheima.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyInterceptor1 implements HandlerInterceptor {
    //在目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String param = request.getParameter("param");
        if (param != null && param.equals("yes")) {
            return true;
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return false;
        }
    }

    //在目标方法执行之后，视图返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        modelAndView.addObject("name", "itheima");
    }

    //整个流程都执行完毕后，执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
