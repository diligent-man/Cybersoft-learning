package com.ndt.spring.day_36_37_38_39.config;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Primary;


import com.ndt.spring.day_36_37_38_39.dto.BaiVietDTO;


@Configuration
public class DemoBeanConfig {
    @Value("${demo.bean.bc12:Bài viết trên IoC}")
    private String bc12;


    @Bean("baiviet1")
    @Primary
    public BaiVietDTO baiviet1() {
        BaiVietDTO baiVietDTO = new BaiVietDTO();

        baiVietDTO.setTieuDe(bc12);
        return baiVietDTO;
    }


    @Bean("baiviet2")
    public BaiVietDTO baiviet2() {
        BaiVietDTO baiVietDTO = new BaiVietDTO();

        baiVietDTO.setTieuDe("Bai viết 2 nè");
        return baiVietDTO;
    }


}
