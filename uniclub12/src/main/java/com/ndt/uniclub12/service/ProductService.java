package com.ndt.uniclub12.service;

import com.ndt.uniclub12.payload.request.InsertProductRequest;
import org.springframework.web.multipart.MultipartFile;


public interface ProductService {
    void insertProduct(InsertProductRequest req);
}
