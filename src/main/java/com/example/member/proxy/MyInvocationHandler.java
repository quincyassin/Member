package com.example.member.proxy;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("接下来执行方法 -> {}" + method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("方法执行完毕 -> {}" + method.getName());
        return invoke;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) myInvocationHandler.getProxy();
        proxy.setName("小明");
    }
}
