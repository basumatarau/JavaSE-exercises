package com.testProject.test0005;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {

    private static Random rand = new Random(47L);
    private static final char[] CAPITALS = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
    private static final char[] LOWERS = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
    private static final char[] VOWELS = "aeiou".toCharArray();

    private int count;

    RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer charBuffer) throws IOException {

        if (this.count-- == 0) {
            return -1;
        }

        charBuffer.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
        for (int i = 0; i < 4; i++) {
            charBuffer.append(VOWELS[rand.nextInt(VOWELS.length)]);
            charBuffer.append(LOWERS[rand.nextInt(LOWERS.length)]);
        }
        charBuffer.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomWords(10));
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
