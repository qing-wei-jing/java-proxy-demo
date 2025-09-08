package com.example.javaproxydemo.dynamic_proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 2. 实现MethodInterceptor接口，定义代理逻辑
class LogMethodInterceptor implements MethodInterceptor {
    /**
     * 拦截方法调用
     * @param obj 代理对象
     * @param method 目标方法
     * @param args 方法参数
     * @param proxy 方法代理对象
     * @return 方法返回值
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 方法执行前的增强操作
        System.out.println("===== 日志开始 =====");
        System.out.println("执行方法: " + method.getName());
        
        // 调用目标对象的方法
        // 使用proxy.invokeSuper()而不是method.invoke()，性能更好
        Object result = proxy.invokeSuper(obj, args);
        
        // 方法执行后的增强操作
        System.out.println("方法执行完成");
        System.out.println("===== 日志结束 =====\n");
        
        return result;
    }
}