package com.example.member.controller;

import com.example.member.entity.MedicalTeams;
import com.example.member.service.MedicalTeamsService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医疗组
 */
@RestController
@RequestMapping("medical/teams")
public class MedicalTeamsController {

    @Resource
    private MedicalTeamsService medicalTeamsService;

    @PostMapping("/save")
    public void save(MedicalTeams medicalTeams) {
        medicalTeamsService.save(medicalTeams);
    }
}
