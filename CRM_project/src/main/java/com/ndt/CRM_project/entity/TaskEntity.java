// package com.ndt.CRM_project.entity;
//
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
//
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
//
//
// @Getter
// @Setter
// @NoArgsConstructor
// public class TaskEntity {
//     private Integer id;
//
//     private String name;
//
//     private LocalDate startDate;
//
//     private LocalDate endDate;
//
//
//     public String getFormattedStartDate() {
//         return startDate != null ?
//             startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
//     }
//
//
//     public String getFormattedEndDate() {
//         return endDate != null ?
//             endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
//     }
// }
