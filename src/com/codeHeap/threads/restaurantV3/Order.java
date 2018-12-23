package com.codeHeap.threads.restaurantV3;

import com.codeHeap.threads.restaurantV3.food.Food;

public class Order {
    private static int counter = 0;
    private final int id = ++counter;
    private final Customer customer;
    private final Waiter waiter;
    private final Food food;

    Order(Customer customer, Waiter waiter, Food food) {
        this.customer = customer;
        this.waiter = waiter;
        this.food = food;
    }

    public Food orderedFood() {
        return food;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order#" + id + ", ordered: " +
                food + ", for: " + customer +
                ", served by: " + waiter;
    }
}
