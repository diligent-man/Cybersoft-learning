package com.ndt.uniclub12.service;

import java.util.List;


import com.ndt.uniclub12.dto.ProductDTO;
import com.ndt.uniclub12.payload.request.InsertProductRequest;


public interface ProductService {
    ProductDTO insertProduct(InsertProductRequest req);


    List<ProductDTO> getProducts();
}
