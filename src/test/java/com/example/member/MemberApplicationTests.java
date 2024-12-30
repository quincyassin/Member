package com.example.member;

import com.example.member.entity.BedAssignments;
import com.example.member.service.EmployeesService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class MemberApplicationTests {

    @Resource
    private EmployeesService employeesService;

    @Test
    void contextLoads() {
//        BedAssignments bedAssignments = new BedAssignments();
//        bedAssignments.setTeamId(1);
//        bedAssignments.setEmployeeId(1);
//        bedAssignments.setBedId(1);
//        LocalDate today = LocalDate.now();
//        LocalDate next = today.plusDays(1);
//        bedAssignments.setStartTime(today);
//        bedAssignments.setEndTime(next);

        BedAssignments bedAssignments = new BedAssignments();
        bedAssignments.setTeamId(1);
        bedAssignments.setEmployeeId(2);
        bedAssignments.setBedId(2);
        LocalDate today = LocalDate.now();
        LocalDate next = today.plusDays(1);
        LocalDate pre = today.plusDays(2);
        bedAssignments.setStartTime(next);
        bedAssignments.setEndTime(pre);

        System.out.println(employeesService.saveEmployeesInfo(bedAssignments));
    }

}
