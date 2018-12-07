package com.codeHeap.generics.generalizedMethods.sets;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static <T> Set<T> union(Set<T> setOne, Set<T> setTwo){

        if (setOne instanceof EnumSet) {
            @SuppressWarnings("unchecked")
            Set<T> clone = ((EnumSet) setOne).clone();
            clone.addAll(setTwo);
            return clone;
        }

        HashSet<T> result = new HashSet<T>(setOne);
        result.addAll(setTwo);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> setOne, Set<T> setTwo){

        if(setOne instanceof EnumSet){
            @SuppressWarnings("unchecked")
            Set<T> clone = ((EnumSet) setOne).clone();
            clone.retainAll(setTwo);
            return clone;
        }

        HashSet<T> result = new HashSet<T>(setOne);
        result.retainAll(setTwo);
        return result;
    }

    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet){

        if(superSet instanceof EnumSet){
            @SuppressWarnings("unchecked")
            Set<T> clone = ((EnumSet) superSet).clone();
            clone.removeAll(subSet);
            return clone;
        }

        HashSet<T> result = new HashSet<>(superSet);
        result.removeAll(subSet);
        return result;
    }

    public static <T> Set<T> complement(Set<T> setOne, Set<T> setTwo){
        return difference(union(setOne, setTwo),intersection(setOne, setTwo));
    }
}
