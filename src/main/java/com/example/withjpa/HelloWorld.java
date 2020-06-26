package com.example.withjpa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }    
}