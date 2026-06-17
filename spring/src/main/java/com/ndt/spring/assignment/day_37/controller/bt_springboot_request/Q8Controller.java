package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.*;
import java.nio.file.*;

import java.io.IOException;


import jakarta.annotation.PostConstruct;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;


import com.ndt.spring.assignment.day_37.request.bt_springboot_request.Q8Request;


@Controller("btSpringbootRequestQ8Controller")
@RequestMapping("/assignment/day_37/bt-springboot-request/q8")
public class Q8Controller {
    private final Path uploadPath = Paths.get("./uploaded_files").toAbsolutePath().normalize();


    @PostConstruct
    public void init() {
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                System.out.println("Could not create directory: " + uploadPath);
            }
        }
    }


    @PostMapping(value = "/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, Object>> uploadFile(
        @RequestPart(required = false) List<MultipartFile> files,
        @RequestPart(required = false) Q8Request body
    ) {
        Map<String, Object> result = new HashMap<>();
        String msg = "Uploaded successfully !";

        if (files.size() != body.getTitles().size() ||
            files.size() != body.getDescriptions().size() ||
            files.size() != body.getTags().size()
        ) {
            msg = "Elements for one of these  array (titles, desscriptions, tags) are inequivalent to files";
            result.put("msg", msg);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        List<Map<String, Object>> uploadedFileLst = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            String filename = file.getOriginalFilename();

            String title = body.getTitles().get(i);
            String description = body.getDescriptions().get(i);
            List<String> tag = body.getTags().get(i);

            Map<String, Object> uploadedFile = new HashMap<>();

            uploadedFile.put("filename", filename);
            uploadedFile.put("title", title);
            uploadedFile.put("description", description);
            uploadedFile.put("tags", tag);

            uploadedFileLst.add(uploadedFile);

            if (filename != null) {
                Path destination = uploadPath.resolve(filename).normalize();

                try {
                    file.transferTo(destination);
                } catch (IOException e) {
                    System.out.println("Could not move file to " + uploadPath);
                }
            }
        }

        result.put("msg", msg);
        result.put("uploadedFiles", uploadedFileLst);

        return ResponseEntity.ok(result);
    }
}
