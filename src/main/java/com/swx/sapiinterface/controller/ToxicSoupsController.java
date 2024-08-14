package com.swx.sapiinterface.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swx.sapiinterface.domain.Lovetalk;
import com.swx.sapiinterface.domain.ToxicSoups;
import com.swx.sapiinterface.service.LovetalkService;
import com.swx.sapiinterface.service.ToxicSoupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController()
@RequestMapping("/toxicsoups")
public class ToxicSoupsController {
    @Autowired
    private ToxicSoupsService toxicSoupsService;


    @GetMapping("/")
    public String getRandomToxicSoups() {

        long startTime = System.currentTimeMillis();


        Random random = new Random();
        int randomNumber = random.nextInt(50) + 1;

        QueryWrapper<ToxicSoups> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", randomNumber);
        ToxicSoups toxicSoups = toxicSoupsService.getOne(queryWrapper);

        // 使用java.util.Date
        long endTime = System.currentTimeMillis();
        // 计算并打印方法执行时间
        long executionTime = endTime - startTime;
        System.out.println("Method executed in: " + executionTime + " ms");
        return toxicSoups.getData();
    }




}
