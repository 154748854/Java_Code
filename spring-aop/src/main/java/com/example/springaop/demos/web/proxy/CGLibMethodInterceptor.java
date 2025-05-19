package com.example.springaop.demos.web.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibMethodInterceptor implements MethodInterceptor {

    private Object target;

    public CGLibMethodInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 调用目标对象的方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是中介,开始代理");
        Object result = method.invoke(target, objects);
        return result;
    }
}
