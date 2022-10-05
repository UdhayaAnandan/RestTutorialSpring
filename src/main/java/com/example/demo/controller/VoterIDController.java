package com.example.demo.controller;

import com.example.demo.entity.VoterRequest;
import com.example.demo.exception.VoterDataNotFoundException;
import com.example.demo.service.VoterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class VoterIDController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private VoterService voterService;


    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VoterRequest addVoterData(@Validated @RequestBody VoterRequest voterRequest) {
        return voterService.insertVoterDtls(voterRequest);
    }

    @GetMapping("/getAllData")
    public List<VoterRequest> fetchAllVoterData() {
        return voterService.fetchAllVoterDtls();
    }

    @GetMapping("/getByID/{id}")
    public VoterRequest fetchByVoterId(@PathVariable("id") String voterId) throws VoterDataNotFoundException {
        return voterService.fetchVoterDtlsById(voterId);
    }

    @GetMapping("/getByFNameLName/{fname}/{lname}")
    public List<VoterRequest> fetchByFNameAndLName(@PathVariable("fname") String fname,
                                                   @PathVariable("lname") String lname) {
        return voterService.fetchVoterDtlsByFnameLname(fname, lname);
    }

    @PostMapping("/DataByFName")
    public List<VoterRequest> fetchByFname(@RequestBody VoterRequest voterRequest) {
        if (Objects.nonNull(voterRequest.getFname()))
            return voterService.fetchVoterDtlsByFname(voterRequest.getFname());
        else
            return List.of();
    }

    @DeleteMapping("/DeleteById/{id}")
    public String deleteByID(@PathVariable("id") String voterId) throws VoterDataNotFoundException {
        voterService.deleteVoterDtlsById(voterId);
        return "Deleted";
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<VoterRequest> updateByID(@RequestBody VoterRequest voterRequest, @PathVariable("id") String voterid) {
        return new ResponseEntity<>(voterService.updateVoterDltsById(voterRequest, voterid), HttpStatus.OK);
    }


}



