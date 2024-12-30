package com.example.member.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.member.entity.BedAssignments;
import com.example.member.entity.Employees;
import com.example.member.entity.TeamMembers;
import com.example.member.mapper.BedAssignmentsMapper;
import com.example.member.mapper.EmployeesMapper;
import com.example.member.mapper.TeamMemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeesService extends ServiceImpl<EmployeesMapper, Employees> {

    @Resource
    private BedsService bedsService;

    @Resource
    private BedAssignmentService bedAssignmentService;

    @Resource
    private TeamMemberMapper teamMemberMapper;

    @Resource
    private BedAssignmentsMapper bedAssignmentsMapper;


    public String saveEmployeesInfo(BedAssignments bedAssignments) {
        boolean flag = canAssignEmployeeToTeamAndBed(bedAssignments.getEmployeeId(),
                bedAssignments.getTeamId(),
                bedAssignments.getBedId(),
                bedAssignments.getStartTime(),
                bedAssignments.getEndTime());
        if (!flag) {
            return "failed";
        }
        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setTeamId(bedAssignments.getTeamId());
        teamMembers.setEmployeeId(bedAssignments.getEmployeeId());
        teamMembers.setStartTime(bedAssignments.getStartTime());
        teamMembers.setEndTime(bedAssignments.getEndTime());
        teamMemberMapper.insert(teamMembers);
        bedAssignmentService.save(bedAssignments);
        return "success";
    }

    public boolean canAssignEmployeeToTeamAndBed(int employeeId, int teamId, int bedId, LocalDate startTime, LocalDate endTime) {

        // 1. 检查员工是否在该时间段内已经被分配到其他医疗组
        boolean isEmployeeAvailable = isEmployeeAvailableForTeam(employeeId, teamId, startTime, endTime);
        if (isEmployeeAvailable) {
            return false;
        }

        // 2. 检查病床是否在该时间段内已被分配
        boolean isBedAvailable = isBedAvailable(bedId, startTime, endTime);
        if (isBedAvailable) {
            return false;
        }

        // 如果病床可以分配，则返回true
        return true;
    }

    /**
     * 检查员工是否可以分配到该医疗组（同一时间段内不能冲突）
     *
     * @param employeeId
     * @param teamId
     * @param startTime
     * @param endTime
     * @return
     */
    private boolean isEmployeeAvailableForTeam(int employeeId, int teamId, LocalDate startTime, LocalDate endTime) {
        return teamMemberMapper.existsByEmployeeIdAndTimeOverlap(employeeId, teamId, startTime, endTime);
    }

    /**
     * 检查病床是否在该时间段内已被分配给其他员工
     *
     * @return
     */
    private boolean isBedAvailable(int bedId, LocalDate startTime, LocalDate endTime) {
        // 查找是否有时间段重叠的分配记录
        return bedAssignmentsMapper.existsByBedIdAndTimeOverlap(bedId, startTime, endTime);
    }
}
