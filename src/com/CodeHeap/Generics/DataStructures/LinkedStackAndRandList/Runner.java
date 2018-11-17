package com.CodeHeap.Generics.DataStructures.LinkedStackAndRandList;

public class Runner {
    public static void main(String[] args) {
        String testString = "This is a Test to be tested with collections...";
        LinkedStack<String> stack = new LinkedStack<>();
        for (String word : testString.split(" ")) {
            stack.push(word);
        }
        String word;
        while((word = stack.pop())!=null){
            System.out.println(word);
        }

        RandomList<String> randomList = new RandomList<>();
        for (String str : testString.split(" ")) {
            randomList.add(str);
        }

        for (int i = 0; i < randomList.size(); i++) {
            System.out.println(randomList.select());
        }

    }
}
