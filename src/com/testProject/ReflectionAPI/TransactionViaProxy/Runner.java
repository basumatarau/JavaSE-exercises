package com.testProject.ReflectionAPI.TransactionViaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        Initializer.init();

        User u = new User(5);
        int goodId =3;

        System.out.println(u);
        u.askForGood(goodId);
        u.getGood(goodId);
        u.putGoodToBasket(goodId);
        System.out.println(u);

        ISelectGoods proxyOb;
        Class<?> proxyClass = Proxy.getProxyClass(ISelectGoods.class.getClassLoader(), ISelectGoods.class);
        try {
            proxyOb = (ISelectGoods)proxyClass.getConstructor(InvocationHandler.class)
                    .newInstance(new DynamicProxyHandler(u));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        goodId =4;

        System.out.println(u);
        proxyOb.askForGood(goodId);
        proxyOb.getGood(goodId);
        proxyOb.putGoodToBasket(goodId);
        System.out.println(u);

    }
}
