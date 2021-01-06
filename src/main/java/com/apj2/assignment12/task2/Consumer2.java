package com.apj2.assignment12.task2;
// Consumer with a run method that loops, reading 10 values from buffer.

import com.apj2.assignment12.services.FileService;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class Consumer2 implements Callable<List<Result>> {
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Consumer2(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }


    @Override
    public List<Result> call() throws Exception {
        List<Result> resultList=new ArrayList<>();
        for (File file : FileService.getFilesFromPath()) {
            try {
                 resultList.add(sharedLocation.syncGet());
                System.out.println("Consumer read now " + file.getName());
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        return resultList;
    }
}