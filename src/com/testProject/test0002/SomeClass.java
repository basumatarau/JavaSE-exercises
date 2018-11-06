package com.testProject.test0002;

public class SomeClass {
    private class SomInnerClass implements SomeInterface{
        @Override
        public void print() {
            System.out.println("method print() has been called by the object of "+ getClass().getSimpleName());
        }
    }

    SomeInterface someInterFace(){
        return new SomInnerClass();
    }
    public static void main(String[] args) {

    }
}
