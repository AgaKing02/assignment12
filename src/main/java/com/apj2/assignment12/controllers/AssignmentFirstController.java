package com.apj2.assignment12.controllers;

import com.apj2.assignment12.models.BlockingBufferTest;
import com.apj2.assignment12.services.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;

@RestController
public class AssignmentFirstController {

    @GetMapping("/firstTask")
    public Iterable<File> getChangedFiles() {
        try {
            BlockingBufferTest.main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(FileService.getFilesFromPath());
    }
}
