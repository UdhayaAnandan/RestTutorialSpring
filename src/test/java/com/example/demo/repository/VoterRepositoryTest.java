package com.example.demo.repository;

import com.example.demo.entity.VoterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VoterRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    VoterRepository voterRepository;
    private String fname = "udhayaa";
    private String lname = "Kumara";

    @BeforeEach
    void setUp() {
        VoterRequest voterRequest = VoterRequest.builder()
                .voterID("SB009")
                .fname("udhayaa")
                .lname("Kumara")
                .fathername("Anandan").addressid(001).dob("05/05/1995").build();
        testEntityManager.persist(voterRequest);

    }

    @Test
    void findByFnameAndLname() {
        Optional<VoterRequest> voterRequestList = voterRepository.findById("SB009");
        assertEquals(voterRequestList.get().getFname(), fname);

    }
}