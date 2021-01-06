package com.apj2.assignment12.controllers;

import com.apj2.assignment12.task2.Result;
import com.apj2.assignment12.task2.ResultHolder;
import com.apj2.assignment12.task2.SharedBufferTest2;
import com.apj2.assignment12.task2.SynchronizedBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AssignmentSecondController {

    @GetMapping("/secondTask")
    public String getChangedFiles(@RequestParam(name = "word", required = true) String word, Model model) {
        ResultHolder resultHolder = null;
        try {
             resultHolder=new ResultHolder((List<Result>) SharedBufferTest2.main(word));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("results", resultHolder);
        return "SecondTask";
    }
}

