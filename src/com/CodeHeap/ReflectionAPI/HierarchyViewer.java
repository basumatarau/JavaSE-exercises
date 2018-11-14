package com.CodeHeap.ReflectionAPI;

import com.CodeHeap.eventDrivenSystemExample.GreenhouseControls;

import java.lang.reflect.Method;

public class HierarchyViewer {
    public void print(Class<?> cl, int offset) throws IllegalAccessException, InstantiationException{
        StringBuilder offsetStr =new StringBuilder();
        for (int i = 0; i < offset; i++) {
            offsetStr.append('\t');
        }
        offset++;
        if(cl.getSuperclass()==null){
            System.out.println(offsetStr.append(cl.getName()));
            printFields(cl, offset);
            return;
        }
        print(cl.getSuperclass(), offset);
        System.out.println(offsetStr.append(cl.getName()));
        printFields(cl, offset);
    }

    public void printFields(Class<?> cl, int offset){
        StringBuilder offsetStr = new StringBuilder();
        for (int i = 0; i < offset; i++) {
            offsetStr.append('\t');
        }
        for (Method method : cl.getDeclaredMethods()) {
            System.out.println(offsetStr.toString()+method.getName());
        }
    }

    public static void main(String[] args) {
        HierarchyViewer hviewer = new HierarchyViewer();
        GreenhouseControls gc = new GreenhouseControls();
        GreenhouseControls.Bell bell = gc.new Bell(1000);
        try {
            hviewer.print(bell.getClass(), 0);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
