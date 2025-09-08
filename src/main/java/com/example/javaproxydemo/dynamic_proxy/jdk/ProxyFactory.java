package com.example.javaproxydemo.dynamic_proxy.jdk;

import java.lang.reflect.Proxy;

// 4. 代理工厂，用于创建代理对象
class ProxyFactory {
    /**
     * 创建代理对象
     *
     * @param target 目标对象
     * @return 代理对象
     */
    public static Object createProxy(Object target) {
        // 使用Proxy.newProxyInstance()方法创建代理对象
        return Proxy.newProxyInstance(
                // 类加载器
                target.getClass().getClassLoader(),
                // 目标对象实现的接口
                target.getClass().getInterfaces(),
                // InvocationHandler实现类
                new LogInvocationHandler(target)
        );
    }
}