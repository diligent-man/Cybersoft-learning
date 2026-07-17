package com.ndt.uniclub12.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final FilesStorageService filesStorageService;


    @Override
    public void insertProduct(MultipartFile file) {
        filesStorageService.save(file);
    }
}
