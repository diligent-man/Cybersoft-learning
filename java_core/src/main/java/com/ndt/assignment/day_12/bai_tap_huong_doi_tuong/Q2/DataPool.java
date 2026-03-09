package com.ndt.assignment.day_12.bai_tap_huong_doi_tuong.Q2;

import java.util.*;


public class DataPool {
    private final String[] names = new String[]{
        "Nguyễn Văn A",
        "Nguyễn Văn B",
        "Nguyễn Văn C",
        "Nguyễn Văn D",
        "Nguyễn Văn E"
    };

    private final String[] idPrefixes = new String[]{
        "BE", "DE", "FE",
        "DA", "DS", "PM"
    };

    Map<Integer, Integer> nameCounter;

    Map<Integer, Integer> idCounter;


    public DataPool() {
        nameCounter = new HashMap<>();
        idCounter = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            nameCounter.put(i, 0);
        }

        for (int i = 0; i < idPrefixes.length; i++) {
            idCounter.put(i, 0);
        }
    }


    private String _getAndUpdate(Integer idx, Map<Integer, Integer> mapping, String[] strLst) {
        String val = String.format("%s%s", strLst[idx], mapping.get(idx));
        mapping.put(idx, mapping.get(idx) + 1);
        return val;
    }


    public String getName() {
        int idx = new Random().nextInt(names.length);
        return _getAndUpdate(idx, nameCounter, names);
    }


    public String getId() {
        int idx = new Random().nextInt(names.length);
        return _getAndUpdate(idx, nameCounter, idPrefixes);
    }
}
