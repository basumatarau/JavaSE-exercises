package com.CodeHeap.Generics.generalizedExceptions;

import java.util.List;

public class ThrowGenericException {

    public static void main(String[] args) {

        ProcessRunner<String, Failure1> runner1 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner1.add(new Processor1());
        }
        try {
            List<String> strings = runner1.processAll();
            System.out.println(strings);
        } catch (Failure1 failure1) {
            //throw new RuntimeException(failure1);
            System.out.println(failure1);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try{
            List<Integer> integers = runner2.processAll();
            System.out.println(integers);
        }catch (Failure2 failure2){
            //throw new RuntimeException(failure2);
            System.out.println(failure2);
        }

    }

}
