package com.codeHeap.annotation.annoProcessingExample;

@ExtractInterface(value = "IMultiplier")
public class Multiplier {
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
        Multiplier m = new Multiplier();
        System.out.println("2*2=" + m.multiply(2, 2));
    }
}
