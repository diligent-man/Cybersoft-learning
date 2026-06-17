package com.ndt.spring.day_36_37_38_39.controller;


import com.ndt.spring.day_36_37_38_39.dto.BaiVietDTO;
import com.ndt.spring.day_36_37_38_39.dto.BinhLuanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController("demoJsonController")
@RequestMapping("/day_36_37_38_39/demo-json")
public class DemoJsonController {

    @GetMapping
    public ResponseEntity<BaiVietDTO> demoJson() {
        BaiVietDTO baiVietDTO = new BaiVietDTO();

        baiVietDTO.setTieuDe("Phe cứng rắn chống chiến tranh");
        baiVietDTO.setNoiDung("Các quan chứng theo đường lối cứng rắn ...");
        baiVietDTO.setGioiTinh(true);
        baiVietDTO.setTuoi(20);

        List<BinhLuanDTO> binhLuans = new ArrayList<>();

        BinhLuanDTO binhLuanDTO = new BinhLuanDTO();
        binhLuanDTO.setTieuDe("World cup 2026");
        binhLuanDTO.setNoiDung("Chau Phi & Mexico 2 thẻ đỏ");
        binhLuanDTO.setSoSao(6);
        binhLuans.add(binhLuanDTO);

        binhLuanDTO = new BinhLuanDTO();
        binhLuanDTO.setTieuDe("Khai mạc World cup 2026");
        binhLuanDTO.setNoiDung("Shakira lắc đít");
        binhLuanDTO.setSoSao(3);
        binhLuans.add(binhLuanDTO);

        baiVietDTO.setBinhLuans(binhLuans);
        return ResponseEntity.ok(baiVietDTO);
    }
}
