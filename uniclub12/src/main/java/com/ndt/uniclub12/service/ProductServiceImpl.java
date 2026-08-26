package com.ndt.uniclub12.service;

import java.util.List;

import jakarta.transaction.Transactional;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


import com.ndt.uniclub12.dto.ProductDTO;

import com.ndt.uniclub12.entity.SizeEntity;
import com.ndt.uniclub12.entity.ColorEntity;
import com.ndt.uniclub12.entity.ProductEntity;
import com.ndt.uniclub12.entity.VariantEntity;

import com.ndt.uniclub12.repo.ProductRepo;
import com.ndt.uniclub12.repo.VariantRepo;

import com.ndt.uniclub12.payload.request.InsertProductRequest;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    private final VariantRepo variantRepo;

    private final FilesStorageService filesStorageService;


    @Override
    public List<ProductDTO> getProducts() {
        return productRepo
            .findAll()
            .stream()
            .map(ProductDTO::fromEntity)
            .toList();
    }


    @Override
    @Transactional  // only use with insert & update logic with more than 2 tables
    public ProductDTO insertProduct(InsertProductRequest req) {
        // save image before date
        filesStorageService.save(req.getFile());

        ProductEntity product = new ProductEntity();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setInformation(req.getInformation());
        product.setPrice(req.getPrice());

        VariantEntity variant = new VariantEntity();

        ProductEntity insertedProduct = productRepo.save(product);


        ColorEntity color = new ColorEntity();
        color.setId(req.getIdColor());

        SizeEntity size = new SizeEntity();
        size.setId(req.getIdSize());

        variant.setSize(size);
        variant.setColor(color);
        variant.setProduct(insertedProduct);
        variant.setPrice(req.getPrice());
        variant.setQuantity(req.getQuantity());
        variant.setImages(req.getFile().getOriginalFilename());

        variantRepo.save(variant);
        insertedProduct.setVariants(List.of(variant));
        return ProductDTO.fromEntity(insertedProduct);
    }
}
