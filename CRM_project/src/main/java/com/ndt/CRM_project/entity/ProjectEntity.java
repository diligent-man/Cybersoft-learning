package com.ndt.CRM_project.entity;

import java.util.Locale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import lombok.*;


@Getter
@ToString
@NoArgsConstructor
public class ProjectEntity {
    @Setter
    private Integer id;

    @Setter
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    @Getter(AccessLevel.NONE)
    private final DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Getter(AccessLevel.NONE)
    private final DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.of("vi", "VN"));


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate, parseFormatter);
    }


    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate, parseFormatter);
    }


    public String getFormattedStartDate() {
        return startDate != null ?
            startDate.format(displayFormatter) : "";
    }


    public String getFormattedEndDate() {
        return endDate != null ?
            endDate.format(displayFormatter) : "";
    }
}
