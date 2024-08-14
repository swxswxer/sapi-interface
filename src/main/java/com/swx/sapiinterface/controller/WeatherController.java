package com.swx.sapiinterface.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.swx.sapiclientsdk.model.City;
import com.swx.sapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

@RestController()
@RequestMapping("/weather")
public class WeatherController {

    @PostMapping("/weather")
    public String getWeatherByCity(@RequestBody String city , HttpServletRequest request) {
        String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s,cn&APPID=%s";
//        String city = "Beijing"; // 替换为你想查询的城市名
        City cityBean = JSONUtil.toBean(city, City.class);
        String cityStr = cityBean.getCity();

        String API_KEY = "607f868a754bb38ea5b8a307c487086e"; // 替换为你的API密钥
        try{
            URL url = new URL(String.format(WEATHER_URL, cityStr, API_KEY));
            HttpResponse httpResponse = HttpRequest.get(url.toString()).execute();
//            System.out.println(httpResponse.getStatus());
            String result = httpResponse.body();
//            System.out.println("result = " + result);
            return result;
        }catch (Exception e){
            return e.getMessage();
        }

    }


}
