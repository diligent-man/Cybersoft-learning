package com.ndt.spring.assignment.day_39.controller.p1;

import java.util.List;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.assignment.day_39.entity.p1.Q5Entity;
import com.ndt.spring.assignment.day_39.response.p1.Q5Response;


@RestController("btIoCP1Q5Controller")
@RequestMapping("/assignment/day_39/ioc/p1/q5")
public class Q5Controller {
    @GetMapping("")
    public ResponseEntity<Q5Response> getQ5() throws CloneNotSupportedException {
        List<Q5Entity> objLst = new ArrayList<>();

        Q5Entity obj = new Q5Entity();
        obj.setId(1);
        obj.setTotal(100);
        objLst.add((Q5Entity) obj.clone());

        obj.setId(2);
        obj.setTotal(200);
        objLst.add((Q5Entity) obj.clone());


        Q5Response response = new Q5Response();
        response.setOrders(objLst);
        return ResponseEntity.ok(response);
    }
}
