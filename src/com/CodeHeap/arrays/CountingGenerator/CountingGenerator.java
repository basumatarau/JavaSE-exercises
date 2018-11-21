package com.CodeHeap.arrays.CountingGenerator;

public class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;

        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value;

        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static final char[] chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm".toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        private int index = -1;

        @Override
        public java.lang.Character next() {
            index = ++index % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String>{
        int length = 8;
        Generator<java.lang.Character> chGen = new Character();
        String(){}
        String(int length){
            this.length = length;
        }

        @Override
        public java.lang.String next() {
            char[] buff = new char[length];
            for (int i = 0; i < buff.length; i++) {
                buff[i] = chGen.next();
            }
            return new java.lang.String(buff);
        }
    }

    public static class Short implements Generator<java.lang.Short>{
        private short value;
        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer>{
        private int value;
        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements Generator<java.lang.Long>{
        private long value;
        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Double implements Generator<java.lang.Double>{
        private double value;
        @Override
        public java.lang.Double next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float>{
        private float value;
        @Override
        public java.lang.Float next() {
            return value++;
        }
    }
}
