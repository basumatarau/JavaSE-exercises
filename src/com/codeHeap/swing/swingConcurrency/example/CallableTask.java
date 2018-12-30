package com.codeHeap.swing.swingConcurrency.example;

import java.util.concurrent.Callable;

public class CallableTask extends Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        run();
        return "Return value of " + this;
    }
}
