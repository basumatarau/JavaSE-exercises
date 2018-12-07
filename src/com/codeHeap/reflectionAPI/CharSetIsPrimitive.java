package com.codeHeap.reflectionAPI;

public class CharSetIsPrimitive {
    public static boolean isPrimitive(Object ob){
        Class<?> cl = ob.getClass();
        System.out.println(cl.getName() );
        return cl.isPrimitive();
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'b', 'c'};
        Character[] chars2 = new Character[]{'a', 'b', 'c'};
        char ch1 = 'a';
        Character ch2 = 'a';
        Class<?> aClass = ch2.getClass();

        Class<Number> numberClass = Number.class;
        Number number = numberClass.cast(Double.valueOf("3.14"));
        System.out.println(number);

        System.out.println("chars1 isPrimitive: "+ isPrimitive(chars1.getClass()));
        System.out.println("chars2 isPrimitive: "+ isPrimitive(chars2.getClass()));

        System.out.println("ch1 isPrimitive: "+ isPrimitive(char.class));
        System.out.println("ch2 isPrimitive: "+ isPrimitive(ch2.getClass()));
    }
}
