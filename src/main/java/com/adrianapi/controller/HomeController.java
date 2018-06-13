package com.adrianapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    SecurityService securityService;

    @ResponseBody
    @RequestMapping("token")
    public Map<String, Object> generateToken(@RequestParam(value="subject") String subject) {
        String token = securityService.createToken(subject, (45*1000*60)); // expires in 45 minutes
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", token);
        return map;
    }

    @ResponseBody
    @RequestMapping("/get/subject")
    public Map<String, Object> getSubject(@RequestParam(value="token") String token){
        String subject = securityService.getToken(token);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", subject);
        return map;
    }

}
