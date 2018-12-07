package com.codeHeap.test0003;

public class SomeClass {
    private String content;
    private SomeClass(){
        content = "default content";
    }
    private SomeInterface someMethod(){
        class SomeLocalClass implements SomeInterface{
            private String someLocalContent;
            private SomeLocalClass(){
                someLocalContent = "default local content";
            }
            @Override
            public String ping() {
                return someLocalContent;
            }
            public String getSomeLocalContent() {
                return someLocalContent;
            }
        }
        return new SomeLocalClass();
        //content = slc.getSomeLocalContent();
    }

    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        System.out.println(sc.content);
        System.out.println(sc.someMethod().ping());
        System.out.println(sc.content);

    }
}
