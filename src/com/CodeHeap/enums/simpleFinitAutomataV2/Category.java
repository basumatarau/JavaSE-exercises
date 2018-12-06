package com.CodeHeap.enums.simpleFinitAutomataV2;

import java.util.EnumMap;

public enum Category {

    MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS, Input.SOAP, Input.SODA),
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP);

    private Input[] values;
    private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    Category(Input... values){
        this.values = values;
    }

    public static Category categorise(Input inputInstance){
        return categories.get(inputInstance);
    }

    static{
        for (Category category : values()) {
            for (Input type : category.values) {
                categories.put(type, category);
            }
        }
    }
}
