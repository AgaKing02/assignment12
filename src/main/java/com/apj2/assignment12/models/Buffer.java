package com.apj2.assignment12.models;

public interface Buffer<T> {
    void blockingRenameAndPut(T data) throws InterruptedException;
    T blockingGet() throws InterruptedException;
}
