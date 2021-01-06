package com.apj2.assignment12.task2;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SharedBufferTest2 {
    public static List<Result> main(String args) throws InterruptedException {
        // create a newCachedThreadPool
        ExecutorService executorService = Executors.newCachedThreadPool();
        // create SynchronizedBuffer to store ints
        Buffer sharedLocation = new SynchronizedBuffer();
        // execute the Producer and Consumer tasks
        executorService.execute(new Producer2(sharedLocation, args));
        Future<List<Result>> resultFuture=executorService.submit(new Consumer2(sharedLocation));
        executorService.shutdown();
        try {
            return resultFuture.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}