package com.apj2.assignment12.task2;

import java.util.ArrayList;
import java.util.List;

public class ResultHolder {
    public  List<Result> occurrence = new ArrayList<>();

    public ResultHolder(List<Result> occurrence) {
        this.occurrence = occurrence;
    }

    public List<Result> getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(List<Result> occurrence) {
        this.occurrence = occurrence;
    }
}
