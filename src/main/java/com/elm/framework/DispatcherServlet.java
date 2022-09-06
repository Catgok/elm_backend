package com.elm.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@WebServlet("/")
//@WebServlet(name = "DispatcherServlet", value = "/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //中文编码处理
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //获取客户端请求路径
        String path = request.getServletPath();
        //根据请求路径解析方法名和类名
        String className = path.substring(1, path.lastIndexOf('/'));
        String methodName = path.substring(path.lastIndexOf('/') + 1);


        PrintWriter out = null;
        try {
            //通过Controller类全名获取此类的所有信息
            Class clazz = Class.forName("com.elm.controller." + className);
            //创建Controller类的对象
            Object controller = clazz.getConstructor().newInstance();
            // 反射
            //获取Controller类对象中的方法
            Method method = clazz.getMethod(methodName, new Class[]{HttpServletRequest.class});
            //调用上面获取的方法
            Object result = method.invoke(controller, new Object[]{request});

            //获取向客户端响应的输出流
            out = response.getWriter();
            ObjectMapper om = new ObjectMapper();
            //向客户端响应json数据
            out.print(om.writeValueAsString(result));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DispatcherServlet信息：请求url：" + path);
            System.out.println("DispatcherServlet信息：类名：" + className + "\t方法名：" + methodName);
        } finally {
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
