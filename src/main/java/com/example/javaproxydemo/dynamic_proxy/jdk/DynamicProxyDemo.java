package com.example.javaproxydemo.dynamic_proxy.jdk;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        // 创建真实对象
        UserService userService = new UserServiceImpl();
        
        // 创建代理对象
        UserService proxy = (UserService) ProxyFactory.createProxy(userService);
        
        // 通过代理对象调用方法
        proxy.addUser("张三");
        proxy.deleteUser("李四");
    }
}