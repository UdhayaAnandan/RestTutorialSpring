package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TEST")
public class VoterRequest {

    @Id
    @Column(name = "id")
    @NotNull(message = "VoterID Should not empty")
    private String voterID;
    private String fname;
    private String lname;
    private String fathername;
    private String dob;
    private double addressid;


}
