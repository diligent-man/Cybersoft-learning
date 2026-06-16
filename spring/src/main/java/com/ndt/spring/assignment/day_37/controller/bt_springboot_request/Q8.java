package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Controller("btSpringbootRequestQ8")
@RequestMapping("/assignment/day_37/bt-springboot-request/q8")
public class Q8 {
    @Autowired
    private ResourceLoader pdfResourceLoader;

    private final String pdfResourcePath = "classpath:static/resources/pdf";


    @SneakyThrows
    @PostMapping("/documents")
    public ResponseEntity<Map<String, Object>> uploadFile(
        @RequestParam(required = false) List<MultipartFile> files
    ) {
        // String tempPath = System.getProperty("java.io.tmpdir");
        // System.out.println("Windows Temp Path: " + tempPath);

        for (MultipartFile file : files) {
            System.out.println("File Name: " + file.getOriginalFilename());
        }

        System.out.println(pdfResourceLoader.getResource(pdfResourcePath + "/Beginning_XML.pdf").getURL());
        return ResponseEntity.ok(null);
    }
}
