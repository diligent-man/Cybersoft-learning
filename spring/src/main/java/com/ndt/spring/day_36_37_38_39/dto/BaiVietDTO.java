package com.ndt.spring.day_36_37_38_39.dto;

import lombok.Data;

import java.util.List;


@Data
public class BaiVietDTO {
    private String hinhAnh;

    private String tieuDe;

    private String noiDung;

    private boolean gioiTinh;

    private int tuoi;

    private List<BinhLuanDTO> binhLuans;
}
