package com.CodeHeap.Collections.playingWithCollections01;

import com.CodeHeap.Collections.collectionGenerator.CollectionData;
import com.CodeHeap.arrays.CountingGenerator.Generator;
import com.CodeHeap.arrays.CountingGenerator.RandomGenerator;

import java.util.*;

public class Runner {
    public static void main(String[] args) {

        List<StringAddress> list = new ArrayList<>(Collections.nCopies(5, new StringAddress("tome string")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("another string"));
        System.out.println(list);

        Set<String> set = new LinkedHashSet<>(new CollectionData<String>(new Generator<String>() {
            int counter = 0;
            String[] strings = ("strange women lying in ponds distributing of swords " +
                    "is no basis for a system of government").split(" ");
            @Override
            public String next() {
                return strings[counter++ % strings.length];
            }
        }, 17));
        System.out.println(set);

        ArrayList<String> strings = new ArrayList<>(CollectionData.list(new RandomGenerator.String(8), 10));
        System.out.println(strings);
        System.out.println(new HashSet<>(CollectionData.list(new RandomGenerator.Integer(), 10)));


    }
}
