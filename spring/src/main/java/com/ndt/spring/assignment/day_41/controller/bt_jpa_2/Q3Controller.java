package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q3.BookService;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q3.BooksResp;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q3.SearchBookReq;


@RequiredArgsConstructor
@RestController("btJPA2Q3Controller")
@RequestMapping("/assignment/day_41/jpa2/q3/api/books")
public class Q3Controller {
    @Qualifier("btJPA2Q3BookService")
    private final BookService bookService;


    // use @ModelAttribute for request param in searching feat,
    // @RequestBody expects JSON string in body, but search filters here come from the query string
    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchBooks(
        @Valid @ModelAttribute SearchBookReq req
    ) {
        BooksResp books = BooksResp.builder().books(bookService.search(
            req.getAuthor(),
            req.getMinPrice(),
            req.getMaxPrice()
        )).build();

        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(books).build()
        );
    }
}
