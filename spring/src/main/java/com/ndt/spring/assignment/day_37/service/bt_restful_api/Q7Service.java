package com.ndt.spring.assignment.day_37.service.bt_restful_api;

import java.util.*;

import jakarta.annotation.PostConstruct;


import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q7BookEntity;
import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q7AuthorEntity;


@Service("btRestfullAPIQ7Service")
public class Q7Service {
    // Implement unidirection from author POV
    private final List<Q7AuthorEntity> authorLst = new ArrayList<>();

    private final List<Q7BookEntity> bookLst = new ArrayList<>();


    @PostConstruct
    public void init() {
        // Implement unidirection from author POV
        String[] bookNames = new String[]{
            "Tôi thấy hoa vàng trên cỏ xanh",
            "Số đỏ",
            "Cho tôi một vé tuổi thơ",
            "Làm đỉ"
        };

        authorLst.add(new Q7AuthorEntity(1, "Nguyễn Nhật Ánh"));
        authorLst.add(new Q7AuthorEntity(1, "Vũ Trọng Phụng"));

        int i = 0;
        for (Q7AuthorEntity q7AuthorEntity : authorLst) {
            for (int j = i++; j < bookNames.length; j += 2) {
                Q7BookEntity book = new Q7BookEntity(j, bookNames[j]);

                bookLst.add(book);
                q7AuthorEntity.getBookLst().add(book);
            }
        }
    }


    public List<Q7BookEntity> getBookByAuthor(String author) {
        Optional<Q7AuthorEntity> opAuthor = authorLst.stream()
            .filter(ele -> ele.getName().equals(author))
            .findFirst();
        return opAuthor.isPresent() ? opAuthor.get().getBookLst() : new ArrayList<>();
    }
}
