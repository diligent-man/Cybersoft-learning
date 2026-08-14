package com.ndt.uniclub12.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.ndt.uniclub12.service.FilesStorageService;


@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final FilesStorageService filesStorageService;


    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> downloadFile(
        @PathVariable String fileName
    ) {
        Resource file = filesStorageService.load(fileName);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
            .body(file);
    }
}
