package com.apj2.assignment12.task2;
// Producer with a run method that inserts the values 1 to 10 in buffer.

import com.apj2.assignment12.services.FileService;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

public class Producer2 implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;
    private final String word;// reference to shared object

    // constructor
    public Producer2(Buffer sharedLocation, String word) {
        this.sharedLocation = sharedLocation;
        this.word = word;
    }

    // store values from 1 to 10 in sharedLocation
    @Override
    public void run() {
        File[] files = FileService.getFilesFromPath();
        for (File file : files) {
            try {
                sharedLocation.syncPutAndSearch(word, file);
            } catch (InterruptedException | IOException exception) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Producer put " + file.getName());
            }

        }
        System.out.printf("Producer done producing%nTerminating Producer%n");
    }
}