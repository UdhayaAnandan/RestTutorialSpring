package com.example.demo.service;

import com.example.demo.entity.VoterRequest;
import com.example.demo.exception.VoterDataNotFoundException;
import com.example.demo.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService {
    @Autowired
    VoterRepository voterRepository;

    @Override
    public VoterRequest insertVoterDtls(VoterRequest voterRequest) {
        return voterRepository.save(voterRequest);
    }

    @Override
    public List<VoterRequest> fetchAllVoterDtls() {
        return voterRepository.findAll();
    }

    @Override
    public VoterRequest fetchVoterDtlsById(String voterId) throws VoterDataNotFoundException {
        Optional<VoterRequest> voterRequest = voterRepository.findById(voterId);
        if (voterRequest.isPresent())
            return voterRepository.findById(voterId).get();
        else
            throw new VoterDataNotFoundException("Data Not Found");
    }

    @Override
    public List<VoterRequest> fetchVoterDtlsByFnameLname(String fname, String lname) {
        return voterRepository.findByFnameAndLname(fname, lname);
    }

    @Override
    public List<VoterRequest> fetchVoterDtlsByFname(String fname) {
        return voterRepository.findByFname(fname);
    }

    @Override
    public void deleteVoterDtlsById(String voterId) throws VoterDataNotFoundException {
        if (voterRepository.existsById(voterId))
            voterRepository.deleteById(voterId);
        else
            throw new VoterDataNotFoundException("No data available on given VoterID");
        //else Throw Error
    }

    @Override
    public VoterRequest updateVoterDltsById(VoterRequest voterRequest, String voterid) {
        voterRepository.save(voterRequest);
        return voterRepository.findById(voterid).get();
    }
}
