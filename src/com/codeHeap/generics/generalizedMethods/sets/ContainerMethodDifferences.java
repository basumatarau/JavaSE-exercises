package com.codeHeap.generics.generalizedMethods.sets;

import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifferences {
    public static Set<String> methodSet(Class<?> type){
        Set<String> result = new TreeSet<>();
        for (Method method : type.getMethods()) {
            result.add(method.getName());
        }
        return result;
    }
    public static void printInterfaces(Class<?> type){
        System.out.println("Interfaces of class "+ type.getSimpleName()+":");
        List<String> result = new ArrayList<>();
        for (Class<?> anInterface : type.getInterfaces()) {
            result.add(anInterface.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> methodSetObjec = methodSet(Object.class);
    static{
        methodSetObjec.add("clone");
    }

    static <T> void difference(Class<? extends T> superSet, Class<T> subSet){
        System.out.println(superSet.getSimpleName()+" extends "+ subSet.getSimpleName()+
                ", adds the following methods:"
        );
        Set<String> addedMethods = Sets.difference(methodSet(superSet), methodSet(subSet));
        addedMethods.removeAll(methodSetObjec);
        System.out.println(addedMethods);
        printInterfaces(superSet);
    }

    public static void main(String[] args) {
        System.out.println("methods implemented within Collection interface: " + methodSet(Collection.class));
        printInterfaces(Collection.class);

        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);

        System.out.println("methods implemented within Map interface: "+ methodSet(Map.class));
        printInterfaces(Map.class);

        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
