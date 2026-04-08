package com.ndt.assignment.java_core.day_8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// TODO
public class Q1 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> carMode = new HashMap<>();
        carMode.put("gc", List.of(8000, 7500, 7000, 2000));
        carMode.put("gs", List.of(9000, 8500, 8000, 3000));
        carMode.put("gb", List.of(10000, 9500, 9000, 3500));

        System.out.println("""
            Pick 1 of 3 grab car:
                a/ Grab Car (gc)
                b/ Grab SUV (gs)
                c/ Grab Black (gb)
            """);
        sc.nextLine();

        System.out.println("So KM: ");
        int km = sc.nextInt();
        int level = km > 19 ? 3 : km > 1 ? 2 : 1;

        System.out.println("Thoi gian cho: ");
        int time = sc.nextInt();

        int tongTien;
        while (km > 0) {
            if (km > 19) {
                tongTien = carMode.get("gc").get(0) + (km - 20) * 1000;
                System.out.println("Tong tien: " + tongTien);
                System.out.println("Hoa don da in !");
                break;

            }
        }

    }
}
