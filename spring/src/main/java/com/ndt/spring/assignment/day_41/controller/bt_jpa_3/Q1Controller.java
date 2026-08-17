package com.ndt.spring.assignment.day_41.controller.bt_jpa_3;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q1.StudentDTO;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2.UpdateProductReq;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q1.AddStudentReq;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q1.UpdateStudentReq;
import com.ndt.spring.payload.resp.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_3.q1.*;
import com.ndt.spring.assignment.day_41.service.bt_jpa_3.q1.StudentService;


@RequiredArgsConstructor
@RestController("btJPA3Q1Controller")
@RequestMapping("/assignment/day_41/jpa3/q1/api/students")
public class Q1Controller {
    @Qualifier("btJPA3Q1StudentService")
    private final StudentService studentService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getStudents() {
        StudentsResp students = StudentsResp.builder().students(studentService.getAll()).build();
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(students)
                .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudent(
        @PathVariable @Positive Integer id
    ) {
        StudentResp student = StudentResp.builder().student(studentService.getById(id)).build();
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(student)
                .build()
        );
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse> addStudent(
        @Valid @RequestBody AddStudentReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(studentService.save(req))
                .build()
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(
        @PathVariable @Positive Integer id,
        @Valid @RequestBody UpdateStudentReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(studentService.update(id, req))
                .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable @Positive Integer id) {
        StudentDTO student = studentService.delete(id);

        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("Student with name " + student.getName() + " has been deleted")
                .data(student)
                .build()
        );
    }
}
