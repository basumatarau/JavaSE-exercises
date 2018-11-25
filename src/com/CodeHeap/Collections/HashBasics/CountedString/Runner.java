package com.CodeHeap.Collections.HashBasics.CountedString;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        CountedString[] items = new CountedString[5];
        Map<CountedString, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            items[i] = new CountedString("hello world", (char)(i+32));
            map.put(items[i], i);
        }

        System.out.println(map);
        for (CountedString item : items) {
            System.out.println("looking up "+item);
            System.out.println(map.get(item));
        }
    }
}
