package com.example.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.member.entity.TeamMembers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

public interface TeamMemberMapper extends BaseMapper<TeamMembers> {

    // 检查员工是否在指定时间段内已经分配到病床
    @Select("SELECT COUNT(1) > 0 FROM Team_Members tm " +
            "WHERE tm.employee_id = #{employeeId} " +
            "AND tm.team_id != #{teamId} " +
            "AND tm.end_Time > #{startTime}")
    boolean existsByEmployeeIdAndTimeOverlap(@Param("employeeId") int employeeId,
                                             @Param("teamId") int teamId,
                                             @Param("startTime") LocalDate startTime,
                                             @Param("endTime") LocalDate endTime);
}
