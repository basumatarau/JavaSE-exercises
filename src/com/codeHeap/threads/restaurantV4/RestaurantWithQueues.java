package com.codeHeap.threads.restaurantV4;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestaurantWithQueues {
    public static void main(String[] args) throws IOException{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(executorService, 5, 2, 8);
        executorService.execute(restaurant);

        System.out.println("press Enter to stop the simulation");
        System.in.read();
        System.out.println("SHUTDOWN!");
        executorService.shutdownNow();
    }
}
