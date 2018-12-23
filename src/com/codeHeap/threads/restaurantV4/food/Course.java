package com.codeHeap.threads.restaurantV4.food;

import com.codeHeap.enums.util.Enums;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAIN_COURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Dessert.class);

    private Food[] values;

    Course(Class<? extends Food> type){
        values = type.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
}
