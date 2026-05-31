package com.ndt.CRM_project.entity;

import java.util.Locale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import lombok.*;


@Getter
@NoArgsConstructor
public class ProjectEntity {
    @Setter
    private Integer id;

    @Setter
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public void setStartDate(String startDate) {
        this.startDate = convertStringToLocalDate(startDate);
    }


    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public void setEndDate(String endDate) {
        this.startDate = convertStringToLocalDate(endDate);
    }


    public LocalDate convertStringToLocalDate(String dateStr) {
        DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.of("vi", "VN"));
        return LocalDate.parse(dateStr, parseFormatter);
    }


    public String getFormattedStartDate() {
        return startDate != null ?
            startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
    }


    public String getFormattedEndDate() {
        return endDate != null ?
            endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
    }
}
