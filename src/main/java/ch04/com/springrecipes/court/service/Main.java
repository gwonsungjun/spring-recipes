package ch04.com.springrecipes.court.service;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        /*final String url = "http://localhost:8080/members.json";*/
        final String url = "http://localhost:8080/member/{memberId}";
        Map<String, String> params = new HashMap<>();
        params.put("memberId", "1");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class, params);
        System.out.println(result);
    }

}
