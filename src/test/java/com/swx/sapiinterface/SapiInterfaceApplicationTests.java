package com.swx.sapiinterface;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.swx.sapiclientsdk.client.SapiClient;

import com.swx.sapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
class SapiInterfaceApplicationTests {

    @Resource
    private SapiClient sapiClient;


    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("swxswx");
//        String result3 = sapiClient.getUserNameByPost(user);


    }

    @Test
    void testtianqi() {


        String API_KEY = "607f868a754bb38ea5b8a307c487086e"; // 替换为你的API密钥
        String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s,cn&APPID=%s";

//        https://api.openweathermap.org/data/2.5/weather?q=Shanghai,cn&APPID=607f868a754bb38ea5b8a307c487086e
        try {
            String city = "Beijing"; // 替换为你想查询的城市名
            URL url = new URL(String.format(WEATHER_URL, city, API_KEY));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // 打印获取到的天气信息
            System.out.println(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    void tianqi2() throws MalformedURLException {
//        String json = JSONUtil.toJsonStr(user);
        String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s,cn&APPID=%s";
        String city = "Beijing"; // 替换为你想查询的城市名
        String API_KEY = "607f868a754bb38ea5b8a307c487086e"; // 替换为你的API密钥

        URL url = new URL(String.format(WEATHER_URL, city, API_KEY));
        HttpResponse httpResponse = HttpRequest.get(url.toString()).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println("result = " + result);
    }

    @Test
    void RandomUsernameGenerator() {


        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        System.out.println(sb.toString());


    }

}


