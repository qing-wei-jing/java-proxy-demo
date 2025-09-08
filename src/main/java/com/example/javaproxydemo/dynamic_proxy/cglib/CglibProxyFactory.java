package com.example.javaproxydemo.dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

// 3. 代理工厂，用于创建代理对象
class CglibProxyFactory {
    /**
     * 创建代理对象
     * @param targetClass 目标类的Class对象
     * @return 代理对象
     */
    public static Object createProxy(Class<?> targetClass) {
        // 1. 创建Enhancer对象（CGLIB的核心类）
        Enhancer enhancer = new Enhancer();
        
        // 2. 设置父类（目标类）
        enhancer.setSuperclass(targetClass);
        
        // 3. 设置回调对象（MethodInterceptor实现类）
        enhancer.setCallback(new LogMethodInterceptor());
        
        // 4. 创建代理对象（通过字节码技术动态生成目标类的子类）
        return enhancer.create();
    }
}