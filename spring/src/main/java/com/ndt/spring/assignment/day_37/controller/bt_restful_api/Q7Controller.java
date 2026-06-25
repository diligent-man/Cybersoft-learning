package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import java.util.*;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q7BookEntity;
import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q7Service;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ7Controller")
@RequestMapping("/assignment/day_37/restful-api/q7")
public class Q7Controller {
    private final Q7Service q7Service;


    @GetMapping("/books/search")
    public ResponseEntity<Map<String, Object>> getBook(
        @RequestParam(defaultValue = "Nguyễn Nhật Ánh") String author
    ) {
        List<Q7BookEntity> bookLst = q7Service.getBookByAuthor(author);

        Map<String, Object> result = new HashMap<>();
        result.put("author", author);
        result.put("books", bookLst);

        return ResponseEntity.ok(result);
    }
}
