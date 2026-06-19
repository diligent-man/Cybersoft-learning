package com.ndt.spring.assignment.day_39.controller.p1;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.assignment.day_39.entity.p1.Q4Entity;


@RestController("btIoCP1Q4Controller")
@RequestMapping("/assignment/day_39/ioc/p1/q4")
public class Q4Controller {
    @GetMapping("")
    public ResponseEntity<List<Q4Entity>> getQ4() {
        List<Q4Entity> objLst = new ArrayList<>();

        Q4Entity obj = new Q4Entity();
        obj.setId(1);
        obj.setName("A");
        objLst.add((Q4Entity) obj.clone());

        obj.setId(2);
        obj.setName("B");
        objLst.add((Q4Entity) obj.clone());
        return ResponseEntity.ok(objLst);
    }
}
