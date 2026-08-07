package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q3;

import java.util.List;


import lombok.Data;
import lombok.Builder;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q3.BookEntity;


@Data
@Builder
public class BooksResp {
    List<BookEntity> books;
}
