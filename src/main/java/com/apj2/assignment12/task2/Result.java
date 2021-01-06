package com.apj2.assignment12.task2;

public class Result {
    private String fileName;
    private int occurrence;

    public Result(String fileName, int occurrence) {
        this.fileName = fileName;
        this.occurrence = occurrence;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }
}
