package com.swx.sapiinterface.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swx.sapiinterface.domain.Lovetalk;
import com.swx.sapiinterface.service.LovetalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController()
@RequestMapping("/lovetalk")
public class LoveTalkController {

    @Autowired
    private LovetalkService lovetalkService;


    @GetMapping("/")
    public String getRandomLoveTalk() {

        Random random = new Random();
        // 生成 1 到 30 之间的随机数
        int randomNumber = random.nextInt(30) + 1;

        QueryWrapper<Lovetalk> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", randomNumber);
        Lovetalk lovetalk = lovetalkService.getOne(queryWrapper);
        return lovetalk.getData();
    }




}
