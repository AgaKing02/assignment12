package com.apj2.assignment12.controllers;

import com.apj2.assignment12.models.BlockingBufferTest;
import com.apj2.assignment12.services.FileService;
import com.apj2.assignment12.task2.ResultHolder;
import com.apj2.assignment12.task2.SharedBufferTest2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

@RestController
public class AssignmentSecondController {

    @GetMapping("/secondTask")
    public Map<String,Integer> getChangedFiles(@RequestParam(name = "word",required = true)String word) {
        try {
            SharedBufferTest2.main(word);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            return ResultHolder.getOccurrence();
        }
    }
}
