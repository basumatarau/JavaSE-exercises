package com.codeHeap.arrays.equals;

public class Holder {
    public final int value;
    Holder(int value){
        this.value=value;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Holder)
            return this.value==(((Holder)o).value);
        return false;
    }
}
