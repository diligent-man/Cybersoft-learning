package com.ndt.uniclub12.controller;

import java.util.List;
import java.util.stream.Collectors;


import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


import com.ndt.uniclub12.model.FileInfo;
import com.ndt.uniclub12.annotation.ValidFile;
import com.ndt.uniclub12.service.FilesStorageService;

import com.ndt.uniclub12.payload.response.ApiResponse;
import com.ndt.uniclub12.payload.response.UploadFileResponse;


@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FilesController {
    private final FilesStorageService filesStorageService;


    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> uploadFile(
        @ValidFile(maxSize = 10485760)
        @ModelAttribute("file")
        MultipartFile file
    ) {
        String code = "200";
        String message = "Uploaded the file successfully: " + file.getOriginalFilename();

        try {
            filesStorageService.save(file);
            return ResponseEntity.ok(
                UploadFileResponse
                    .builder()
                    .code(code)
                    .message(message)
                    .build()
            );
        } catch (Exception e) {
            code = "417";
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(
                    UploadFileResponse
                        .builder()
                        .code(code)
                        .message(message)
                        .build()
                );
        }
    }


    @GetMapping
    public ResponseEntity<ApiResponse> getFiles() {
        List<FileInfo> fileInfos = filesStorageService.loadAll()
            .map(path -> {
                String filename = path.getFileName().toString();
                String url = MvcUriComponentsBuilder.fromMethodName(
                        FilesController.class,
                        "getFile",
                        path.getFileName().toString()
                    )
                    .build()
                    .toString();

                return new FileInfo(filename, url);
            }).collect(Collectors.toList());
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .message("success")
                .data(fileInfos)
                .build()
        );
    }


    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getFile(
        @PathVariable String fileName
    ) {
        Resource file = filesStorageService.load(fileName);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
            .body(file);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteAllFiles() {
        filesStorageService.deleteAll();
        return ResponseEntity.ok("All files were deleted");
    }
}
