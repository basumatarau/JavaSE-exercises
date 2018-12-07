package com.codeHeap.callbackExample;

public class B {
    private int count = 0;
    U[] uArray;

    B() {
        uArray = new U[10];
    }

    public void invokeAll() {
        for (U u : uArray) {
            u.firstMethod();
            u.secondMethod();
            u.thirdMethod();
        }
    }

    public boolean addU(U u) {
        if (count < uArray.length) {
            uArray[count++] = u;
            return true;
        }
        return false;
    }

    public boolean erazeU(int pos) {
        if (pos < 0 || pos >= uArray.length) {
            return false;
        }
        uArray[pos] = null;
        return true;
    }
}
