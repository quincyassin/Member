package com.example.member.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.member.entity.BedAssignments;
import com.example.member.mapper.BedAssignmentsMapper;
import org.springframework.stereotype.Service;

@Service
public class BedAssignmentService extends ServiceImpl<BedAssignmentsMapper, BedAssignments> {
}
