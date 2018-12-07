package com.codeHeap.generics.covariance.playingAroundV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaptureConversion {

    static <T> void f(Holder<T> holder){
        T t = holder.getInstance();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder holder){
        f(holder);
    }

    static Object unbounded(Holder<List<?>> holder){

        for (Object o : holder.getInstance()) {
            System.out.println(o);
        }
        List<?> instance = holder.getInstance();

        //holder.getInstance().setAndGet(0, null);
        holder.setInstance(new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3)));

        Object o = instance.get(0);
        try {
            o = o.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
        //instance.add(instance.get(0));
    }

    public static void main(String[] args) {
        Holder raw = new Holder(new Integer(1));
        f(raw);
        f2(raw);

        Holder rowBasic = new Holder(new Object());
        f2(rowBasic);

        Holder<?> wildCardHolder = new Holder<>(5.5);
        f2(wildCardHolder);

        Holder<List<?>> holder = new Holder<>(Arrays.asList("this is a test string".split(" ")));
        String str = (String)unbounded(holder);
        System.out.println(str);
        System.out.println(holder.getInstance());
    }
}
