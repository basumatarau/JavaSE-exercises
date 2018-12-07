package com.codeHeap.generics.covariance;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
        //list.add(new Integer(1));
        //list.add(new Object())
    }
}
