package com.ndt.uniclub12.service;

import com.ndt.uniclub12.entity.ColorEntity;
import com.ndt.uniclub12.entity.ProductEntity;
import com.ndt.uniclub12.entity.SizeEntity;
import com.ndt.uniclub12.entity.VariantEntity;
import com.ndt.uniclub12.payload.request.InsertProductRequest;
import com.ndt.uniclub12.repo.ProductRepo;
import com.ndt.uniclub12.repo.VariantRepo;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.hibernate.engine.jdbc.Size;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    private final VariantRepo variantRepo;

    private final FilesStorageService filesStorageService;


    @Override
    @Transactional  // only use with insert & update logic with more than 2 tables
    public void insertProduct(InsertProductRequest req) {
        // save image before date
        filesStorageService.save(req.getFile());


        ProductEntity product = new ProductEntity();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());


        VariantEntity variant = new VariantEntity();

        ProductEntity insertedProduct = productRepo.save(product);

        ColorEntity color = new ColorEntity();
        color.setId(req.getIdColor());

        SizeEntity size = new SizeEntity();
        size.setId(req.getIdSize());

        variant.setSizeEntity(size);
        variant.setColorEntity(color);
        variant.setProductEntity(insertedProduct);
        variant.setPrice(req.getPrice());
        variant.setQuantity(req.getQuantity());
        variant.setImages(req.getFile().getOriginalFilename());

        variantRepo.save(variant);
    }
}
