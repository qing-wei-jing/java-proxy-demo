package com.example.javaproxydemo.dynamic_proxy.cglib;

// 测试类
public class CglibProxyDemo {
    public static void main(String[] args) {
        // 创建代理对象（代理OrderService类）
        OrderService proxy = (OrderService) CglibProxyFactory.createProxy(OrderService.class);
        
        // 通过代理对象调用方法
        proxy.createOrder("ORD-12345");
        proxy.cancelOrder("ORD-12345");
    }
}