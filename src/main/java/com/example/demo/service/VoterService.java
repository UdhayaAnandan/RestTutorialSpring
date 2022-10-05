package com.example.demo.service;

import com.example.demo.entity.VoterRequest;
import com.example.demo.exception.VoterDataNotFoundException;

import java.util.List;

public interface VoterService {
    VoterRequest insertVoterDtls(VoterRequest voterRequest);

    List<VoterRequest> fetchAllVoterDtls();

    VoterRequest fetchVoterDtlsById(String voterId) throws VoterDataNotFoundException;

    List<VoterRequest> fetchVoterDtlsByFnameLname(String fname, String lname);

    List<VoterRequest> fetchVoterDtlsByFname(String fname);

    void deleteVoterDtlsById(String voterId) throws VoterDataNotFoundException;

    VoterRequest updateVoterDltsById(VoterRequest voterRequest, String voterid);
}

