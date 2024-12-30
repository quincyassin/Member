package com.example.member.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BedAssignments {

    private int bedId;

    private int employeeId;

    private LocalDate startTime;

    private LocalDate endTime;

    @TableField(exist = false)
    private String employeeName;

    @TableField(exist = false)
    private String bedNumber;

    @TableField(exist = false)
    private int teamId;
}
