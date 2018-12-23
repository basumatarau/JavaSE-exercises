package com.codeHeap.threads.restaurantV4;

import com.codeHeap.threads.restaurantV4.food.Food;

public class Order {
    private static int counter = 0;
    private final int id = ++counter;
    private final Customer customer;
    private final Food food;

    Order(Customer customer, Food food) {
        this.customer = customer;
        this.food = food;
    }

    Food orderedFood() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order#" + id + ", ordered: " +
                food + ", for: " + customer;
    }
}
