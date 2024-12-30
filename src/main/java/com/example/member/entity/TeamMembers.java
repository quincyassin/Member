package com.example.member.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeamMembers {

    private int teamId;

    private int employeeId;

    private LocalDate startTime;

    private LocalDate endTime;
}
