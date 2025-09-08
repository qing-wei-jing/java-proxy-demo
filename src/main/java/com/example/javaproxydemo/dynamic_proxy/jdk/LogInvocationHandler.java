package com.example.javaproxydemo.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现InvocationHandler接口，定义代理逻辑
class LogInvocationHandler implements InvocationHandler {
    // 目标对象（被代理的对象）
    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理方法逻辑
     * @param proxy  代理对象
     * @param method 目标方法
     * @param args   目标方法参数
     * @return 目标方法返回值
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法执行前的额外操作
        System.out.println("===== 日志开始 =====");
        System.out.println("执行方法: " + method.getName());
        
        // 调用目标对象的方法
        Object result = method.invoke(target, args);
        
        // 方法执行后的额外操作
        System.out.println("方法执行完成");
        System.out.println("===== 日志结束 =====\n");
        
        return result;
    }
}