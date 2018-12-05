package com.CodeHeap.enums.usingInterfaces;

import static com.CodeHeap.enums.usingInterfaces.Food.*;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.BURRITO;
        food = Dessert.CREME_CARAMEL;
        food = Coffee.CAPPUCHINO;
    }
}
