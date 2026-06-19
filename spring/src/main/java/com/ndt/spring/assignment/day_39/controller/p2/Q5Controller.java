package com.ndt.spring.assignment.day_39.controller.p2;


import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController("btIoCP2Q5Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q5")
public class Q5Controller {
    @Value("${app.name:DemoApp}")
    String appName;

    @Value("${app.version:10}")
    Integer appVersion;

    @Value("${app.is-release:false}")
    Boolean isReleased;


    @GetMapping("/get-app-info")
    public ResponseEntity<Map<String, Object>> getAppInfo() {
        Map<String, Object> map = new HashMap<>();

        map.put("appName", appName);
        map.put("appVersion", appVersion);
        map.put("isReleased", isReleased);

        return ResponseEntity.ok(map);
    }
}
