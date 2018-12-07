package com.codeHeap.reflectionAPI.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

class ShowMethods {
    private static String usage =
            "usage:\n" +
            "ShowMthods qualified.class.name\n" +
            "To show all methods in class or:"+
            "ShowMthods qualified.class.name word\n"+
            "To search for methods involving 'word'\n";
    private static Pattern pattern = Pattern.compile("(\\w+\\.)|(native )|(final )");

    public static void main(String[] args) {
        if(args.length<1){
            System.out.println(usage);
            System.exit(0);
        }

        try {
            Class<?> cl = Class.forName(args[0]);

            Method[] methods = cl.getMethods();
            Constructor[] constructors = cl.getConstructors();

            if(args.length==1){
                for (Method method : methods) {
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor constructor : constructors) {
                    System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                }
            }else{
                for (Method method : methods) {
                    if(method.toString().contains(args[1])){
                        System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                    }
                }
                for (Constructor constructor : constructors) {
                    if(constructor.toString().contains(args[1])){
                        System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                    }
                }
            }

        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
