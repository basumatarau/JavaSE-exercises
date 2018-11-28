package com.CodeHeap.IO;

import java.util.Arrays;
import java.util.Collection;

public class PrettyPrint {
    public static String format(Collection<?> collection) {
        if (collection.size() == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");

        for (Object element : collection) {
            if (collection.size() != 1) {
                result.append(" \n");
            }
            result.append(element);
        }
        if (collection.size() != 1) {
            result.append('\n');
        }
        result.append("]");

        return result.toString();
    }

    public static void print(Object[] array) {
        System.out.println(format(Arrays.asList(array)));
    }

    public static void print(Collection<?> collection) {
        System.out.println(format(collection));
    }
}
