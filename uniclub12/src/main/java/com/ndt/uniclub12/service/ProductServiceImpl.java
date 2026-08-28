package com.ndt.uniclub12.service;

import java.time.Duration;
import java.util.List;

import jakarta.transaction.Transactional;


import lombok.RequiredArgsConstructor;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import com.ndt.uniclub12.dto.ProductDTO;

import com.ndt.uniclub12.entity.SizeEntity;
import com.ndt.uniclub12.entity.ColorEntity;
import com.ndt.uniclub12.entity.ProductEntity;
import com.ndt.uniclub12.entity.VariantEntity;

import com.ndt.uniclub12.repo.ProductRepo;
import com.ndt.uniclub12.repo.VariantRepo;

import com.ndt.uniclub12.payload.request.InsertProductRequest;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    private final VariantRepo variantRepo;

    private final ObjectMapper objectMapper;

    private final FilesStorageService filesStorageService;

    private final RedisTemplate<String, String> redisTemplate;

    private static final String PRODUCT_CACHE_KEY = "product:all";


    // @Cacheable("product")
    // @Override
    // public List<ProductDTO> getProducts() {
    //     return productRepo
    //         .findAll()
    //         .stream()
    //         .map(ProductDTO::fromEntity)
    //         .toList();
    // }


    @Override
    public List<ProductDTO> getProducts() {
        try {
            // 1. Đọc cache
            String cache = redisTemplate.opsForValue().get(PRODUCT_CACHE_KEY);

            if (cache != null && !cache.isBlank()) {
                System.out.println("Load Product From Redis");
                return objectMapper.readValue(cache, new TypeReference<>() {
                });
            }

            // 2. Không có cache -> Query DB
            List<ProductDTO> products = productRepo.findAll()
                .stream()
                .map(ProductDTO::fromEntity)
                .toList();

            // 3. Lưu cache 10 phút
            redisTemplate.opsForValue().set(
                PRODUCT_CACHE_KEY,
                objectMapper.writeValueAsString(products),
                Duration.ofMinutes(10));
            return products;
        } catch (Exception e) {
            throw new RuntimeException("Redis Cache Error", e);
        }
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
