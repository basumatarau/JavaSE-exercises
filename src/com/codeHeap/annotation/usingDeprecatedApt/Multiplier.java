package com.codeHeap.annotation.usingDeprecatedApt;

@ExtractInterface(value = "IMultiplier")
public class Multiplier implements IMultiplier {
    @Override
    public int multiply(int a, int b){
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = add(result, a);
        }
        return result;
    }

    private int add(int result, int a) {
        return result + a;
    }

    public static void main(String[] args) {
        IMultiplier m = new Multiplier();
        System.out.println("2*2=" + m.multiply(2, 2));
    }
}
