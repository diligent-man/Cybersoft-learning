package com.ndt.uniclub12.service;

import org.springframework.web.multipart.MultipartFile;


public interface ProductService {
    void insertProduct(MultipartFile file);
}
