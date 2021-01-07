package com.apj2.assignment12.models;
// Two threads manipulating a blocking buffer that properly 
// implements the producer/consumer relationship.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest {
    public static void main() throws InterruptedException {
        // create new thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // create BlockingBuffer to store ints
        Buffer<java.io.File> sharedLocation = new BlockingBuffer();
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}