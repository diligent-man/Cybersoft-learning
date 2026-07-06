package com.ndt.CRM_project.dto.project;

import java.time.LocalDate;


import lombok.*;


import com.ndt.CRM_project.dto.model.BaseTaskDetailModel;


@Getter
@ToString
@NoArgsConstructor
public class UserTaskDetailDTO extends BaseTaskDetailModel {
    private LocalDate submitDate;

    private String submitMessage;

    // TODO: bo sung AM/ PM preprocessing
}
