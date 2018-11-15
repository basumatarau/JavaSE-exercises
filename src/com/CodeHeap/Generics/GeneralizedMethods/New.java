package com.CodeHeap.Generics.GeneralizedMethods;

import java.util.*;

public class New {
    public static <K, V> Map<K, V> map(){
        return new HashMap<K, V>();
    }
    public static <T> List<T> list(){
        return new ArrayList<>();
    }
    public static <T> Queue<T> queue(){
        return new LinkedList<T>();
    }
    public static <T> LinkedList<T> llist(){
        return new LinkedList<T>();
    }
    public static <T> Set<T> set(){
        return new HashSet<T>();
    }
}
