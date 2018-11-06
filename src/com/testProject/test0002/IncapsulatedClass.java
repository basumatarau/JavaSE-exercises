package com.testProject.test0002;

class IncapsulatedClass {
    private class InnerClass implements AnotherInterface{
        private void setOuterString(String str){
            someString = str;
        }
        public void changePrivateMember(String str){
            this.setOuterString(str);
        }
    }

    private String someString;
    String getString(){
        return someString;
    }
    IncapsulatedClass(){
        someString= "empty string";
    }

    IncapsulatedClass(String str){
        someString = str;
    }

    AnotherInterface innerClass(){
        return new InnerClass();
    }
}
