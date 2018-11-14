package com.CodeHeap.test0004;

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] array = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
        };

        boolean pass = true;
        for (Composing composing : array) {
            if(pass){
                pass=false;
                continue;
            }

            composing.dispose();
        }

        shared=new Shared();
        array= new Composing[]{new Composing(shared), new Composing(shared)};
        for (Composing composing : array) {
            composing.dispose();
        }

        System.gc();
    }
}
