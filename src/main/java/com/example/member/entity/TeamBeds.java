package com.example.member.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeamBeds {

    private int teamId;

    private int bedId;

    private LocalDate startTime;

    private LocalDate endTime;
}
