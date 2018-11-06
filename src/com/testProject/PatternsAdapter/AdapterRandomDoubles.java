package com.testProject.PatternsAdapter;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class AdapterRandomDoubles extends RandomDoubles implements Readable {
    private int count;
    AdapterRandomDoubles(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer charBuffer) throws IOException {
        if(this.count--<=0){
            return -1;
        }
        String result = Double.toString(next());
        charBuffer.append(result).append(" ");

        return result.length()+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdapterRandomDoubles(10));
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
