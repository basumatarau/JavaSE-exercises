package com.codeHeap.collections.hashBasics.countedString;

import java.util.ArrayList;
import java.util.List;

public class CountedString {
    private static List<String> strings = new ArrayList<>();
    private String content;
    private int id;
    private char ch;

    CountedString(String content, char ch) {
        this.ch = ch;
        this.content = content;
        strings.add(content);
        id = 0;
        for (String string : strings) {
            if (string.equals(content)) {
                id++;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof CountedString)
                && (content.equals(((CountedString) o).content))
                && (ch == (((CountedString) o).ch));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + content.hashCode();
        result = result * 37 + (int)ch;
        return result;
    }

    @Override
    public String toString() {
        return "String: " + content + ch + ", id: " + id + ", hashCode: " + hashCode() + '\n';
    }
}
