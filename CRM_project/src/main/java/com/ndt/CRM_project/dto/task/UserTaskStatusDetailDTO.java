package com.ndt.CRM_project.dto.task;

import java.util.Locale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Getter
@ToString
@NoArgsConstructor
public class UserTaskStatusDetailDTO {
    @Setter
    @JsonProperty("task_id")
    private Integer taskId;

    @Setter
    @JsonProperty("task_name")
    private String taskName;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("end_date")
    private LocalDate endDate;

    @ToString.Exclude
    @Getter(AccessLevel.NONE)
    private final DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @ToString.Exclude
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
