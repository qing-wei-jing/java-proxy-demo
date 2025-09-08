package com.example.javaproxydemo.dynamic_proxy.cglib;

class OrderService {
    public void createOrder(String orderId) {
        System.out.println("创建订单: " + orderId);
    }
    
    public void cancelOrder(String orderId) {
        System.out.println("取消订单: " + orderId);
    }
}