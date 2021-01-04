package com.apj2.assignment12.task2;

import java.io.File;
import java.io.IOException;

public interface Buffer {
    void syncPutAndSearch(String word, File file) throws InterruptedException, IOException;

    File syncGet() throws InterruptedException;
}
