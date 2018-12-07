package com.codeHeap.reflectionAPI.latentReflection.v1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommunicateReflectively {
    public static void perform(Object speaker, Object... args){
        Class<?> s = speaker.getClass();

        try{
            Method speak = s.getMethod("speak");
            speak.invoke(speaker, args);
        }catch (NoSuchMethodException e) {
            System.out.println(speaker + " can't speak");
            //throw new RuntimeException(e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        try{
            Method sit = s.getMethod("sit");
            sit.invoke(speaker, args);
        }catch (NoSuchMethodException e){
            System.out.println(speaker +" can't sit");
            //throw new RuntimeException(e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        perform(new SmartDog());
        perform(new Mime());

    }
}
