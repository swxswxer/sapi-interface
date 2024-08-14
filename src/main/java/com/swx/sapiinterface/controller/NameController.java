package com.swx.sapiinterface.controller;


import com.swx.sapiclientsdk.model.User;
import com.swx.sapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


/**
 * 查询名称API
 *
 * @author swx
 */
@RestController()
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {

        return "GET你的名字是:" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST你的名字是:" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user , HttpServletRequest request) {
        return "你的用户名是:" + user.getUsername();
    }

    @GetMapping("/randomUsername")
    public String getRandomUsername() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return "生成的用户名:" + sb.toString();
    }


}
