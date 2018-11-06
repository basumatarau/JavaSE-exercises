package com.testProject.test0002;

public class Main {
    public static void main(String[] args) {
        SomeClass obj = new SomeClass();
        SomeInterface ref = obj.someInterFace();
        ref.print();

        IncapsulatedClass instanceOfIncapsClass = new IncapsulatedClass("this line is to be changed...");
        AnotherInterface anotherInterface = instanceOfIncapsClass.innerClass();

        System.out.println(instanceOfIncapsClass.getString());
        anotherInterface.changePrivateMember("this is the line for replacement");

        System.out.println(instanceOfIncapsClass.getString());

    }
}
