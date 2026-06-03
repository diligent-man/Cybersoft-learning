package com.ndt.CRM_project.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


import lombok.*;


@Getter
@ToString
@NoArgsConstructor
public class UserStatusTaskDetail {
    @Setter
    private String taskName;

    @Setter
    private String statusName;

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
