package com.example.demo.repository;

import com.example.demo.entity.VoterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface VoterRepository extends JpaRepository<VoterRequest,String> {
    public List<VoterRequest> findByFnameAndLname(String fname, String lname);
    public List<VoterRequest> findByFname(String fname);

}
