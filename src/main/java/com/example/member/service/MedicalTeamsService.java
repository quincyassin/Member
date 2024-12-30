package com.example.member.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.member.entity.MedicalTeams;
import com.example.member.mapper.MedicalTeamsMapper;
import com.example.member.utils.Snow;
import org.springframework.stereotype.Service;

@Service
public class MedicalTeamsService extends ServiceImpl<MedicalTeamsMapper, MedicalTeams> {

    public boolean save(MedicalTeams medicalTeams) {
        int teamId = Snow.getId();
        medicalTeams.setTeamId(teamId);
        save(medicalTeams);
        return true;
    }
}
