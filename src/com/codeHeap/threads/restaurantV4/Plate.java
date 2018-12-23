package com.codeHeap.threads.restaurantV4;

import com.codeHeap.threads.restaurantV4.food.Food;

public class Plate {
    private final Order order;
    private final Food food;

    Plate(Order order, Food food){
        this.order = order;
        this.food = food;
    }
    public Order getOrder(){
        return order;
    }
    public Food getFood(){
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}
