package com.codeHeap.generics.covariance;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
        //list.release(new Integer(1));
        //list.release(new Object())
    }
}
