package com.example.demo.controller;

import com.example.demo.entity.VoterRequest;
import com.example.demo.service.VoterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//which controller class need to mock
@WebMvcTest(VoterIDController.class)
class VoterIDControllerTest {

    //For Mock the service need to use the MockMVC
    @Autowired
    MockMvc mockMvc;

    @MockBean
    VoterService voterService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testaddVoterData() throws Exception {
        VoterRequest voterRequest = VoterRequest.builder()
                .voterID("SB009").fname("udhayaa").lname("Kumara")
                .fathername("Anandan").addressid(001).dob("05/05/1995").build();
        Mockito.when(voterService.insertVoterDtls(voterRequest)).thenReturn(voterRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/insert").contentType(MediaType.APPLICATION_JSON)
                .content("\t{\n" +
                        "\t\t\"voterID\": \"SRB000001\",\n" +
                        "\t\t\"fname\": \"Udhaya\",\n" +
                        "\t\t\"lname\": \"Kumar\",\n" +
                        "\t\t\"fathername\": \"Anandan TR\",\n" +
                        "\t\t\"dob\": \"26-05-1993\",\n" +
                        "\t\t\"addressid\": 123.0\n" +
                        "\t}")).andExpect(MockMvcResultMatchers.status().isOk());

    }




}