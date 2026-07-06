package com.ndt.CRM_project.dto.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import lombok.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


import com.ndt.CRM_project.model.BaseTaskDetailModel;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserTaskDetailDTO extends BaseTaskDetailModel {
    @JsonProperty("submit_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime submitTime;

    @JsonProperty("submit_message")
    private String submitMessage;

    @ToString.Exclude
    @Getter(AccessLevel.NONE)
    private final DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("hh:mm a");


    public String getFormattedSubmitTime() {
        return submitTime != null ?
            submitTime.format(displayFormatter) : "";
    }
}
