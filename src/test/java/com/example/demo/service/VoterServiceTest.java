package com.example.demo.service;

import com.example.demo.entity.VoterRequest;
import com.example.demo.exception.VoterDataNotFoundException;
import com.example.demo.repository.VoterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterServiceTest {

    @Autowired
    VoterService voterService;

    @MockBean
    VoterRepository voterRepository;

    private final String voterId = "SB001";


    @BeforeEach
    void setUp() {
        Optional<VoterRequest> voterRequest = Optional.ofNullable(VoterRequest.builder()
                .voterID(voterId)
                .fname("udhaya")
                .lname("Kumar")
                .fathername("Anandan").addressid(001).dob("05/05/1995").build());
        Mockito.when(voterRepository.findById(voterId)).thenReturn(voterRequest);

    }

    @Test
    @DisplayName("ValidateVoterDtlsByID")
//    @Disabled
    public void validateVoterDtlsById() throws VoterDataNotFoundException {
        VoterRequest voterRequest = voterService.fetchVoterDtlsById(voterId);
        assertEquals(voterRequest.getVoterID(), voterId);
    }
}