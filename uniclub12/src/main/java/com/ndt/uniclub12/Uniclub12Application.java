package com.ndt.uniclub12;

import jakarta.annotation.Resource;


import lombok.RequiredArgsConstructor;


import org.jspecify.annotations.NonNull;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.ndt.uniclub12.service.FilesStorageService;


@SpringBootApplication
@RequiredArgsConstructor
public class Uniclub12Application implements CommandLineRunner {
    @Resource
    private final FilesStorageService filesStorageService;


    public static void main(String[] args) {
        SpringApplication.run(Uniclub12Application.class, args);
    }


    public void run(String @NonNull [] args) throws Exception {
        filesStorageService.init();
    }
}
