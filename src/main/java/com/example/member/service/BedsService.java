package com.example.member.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.member.entity.Beds;
import com.example.member.mapper.BedsMapper;
import org.springframework.stereotype.Service;

@Service
public class BedsService extends ServiceImpl<BedsMapper, Beds> {
}
