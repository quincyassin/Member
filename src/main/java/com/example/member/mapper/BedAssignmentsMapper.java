package com.example.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.member.entity.BedAssignments;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

public interface BedAssignmentsMapper extends BaseMapper<BedAssignments> {

    // 检查病床是否在指定时间段内已被分配
    @Select("SELECT COUNT(1) > 0 FROM Bed_Assignments ba " +
            "WHERE ba.bed_id = #{bedId} " +
            "AND ba.end_Time > #{startTime}")
    boolean existsByBedIdAndTimeOverlap(@Param("bedId") int bedId,
                                        @Param("startTime") LocalDate startTime,
                                        @Param("endTime") LocalDate endTime);
}
