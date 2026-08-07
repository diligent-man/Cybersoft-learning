package com.ndt.uniclub12.service;

import java.nio.file.*;

import java.io.IOException;

import java.net.MalformedURLException;

import java.util.Objects;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


import com.ndt.uniclub12.exception.SaveFileException;


@Service
public class FilesStorageServiceImpl implements FilesStorageService {
    @Value("${path.upload:uploads}")
    private final Path root = Paths.get("uploads");


    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }


    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(
                file.getInputStream(),
                root.resolve(Objects.requireNonNull(file.getOriginalFilename())),
                StandardCopyOption.REPLACE_EXISTING
            );
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new SaveFileException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }


    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(root, 1)
                .filter(path -> !path.equals(this.root))
                .map(root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
