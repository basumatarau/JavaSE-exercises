package com.codeHeap.threads.restaurantV4;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class OrderTicket {
    private static int counter = 0;
    private final int id = ++counter;
    private final BlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    volatile boolean filled = false;
    private final Table table;

    OrderTicket(Table table){
        this.table = table;
    }

    Table getTable() {
        return table;
    }

    Queue<Order> getOrders(){
        return orders;
    }
    synchronized void addOrder(Order order){
        orders.add(order);
        System.out.println(order + " has been added to " + this);

        if(orders.size()!=table.getnClients()){

            filled = true;
            System.out.println("filled ticket!!!");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + " ";
    }
}
