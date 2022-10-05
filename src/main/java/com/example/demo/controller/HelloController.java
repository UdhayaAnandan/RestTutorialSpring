package com.example.demo.controller;

import com.example.demo.entity.VoterRequest;
import com.example.demo.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/controller")
public class HelloController {
    @Autowired
    private VoterService voterService;

    @GetMapping("/test")
    public String test() {
        return "Udhay Success.";
    }

    @PostMapping("/insert")
    public VoterRequest addVoterData(@RequestBody VoterRequest voterRequest) {
        return voterService.insertVoterDtls(voterRequest);
    }

}
