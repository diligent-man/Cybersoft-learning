package com.ndt.CRM_project.dto.paging;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.annotation.PostConstruct;


@RequiredArgsConstructor
public class PageDTO<T> {
    @NonNull
    @Getter
    private List<T> data;

    @NonNull
    @Getter
    private Integer currentPage;

    @NonNull
    @Getter
    private Integer pageSize;

    @NonNull
    @Getter
    private Integer totalItems;

    private Integer totalPages;

    // required by DataTables bootstrap class //
    @Getter
    @JsonProperty("recordsTotal")
    private int recordsTotal;


    @Getter
    @JsonProperty("recordsFiltered")
    private int recordsFiltered;
    // --- //


    @PostConstruct
    private void postConstruct() {
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.recordsTotal = totalItems;
        this.recordsFiltered = totalItems;

    }
}
