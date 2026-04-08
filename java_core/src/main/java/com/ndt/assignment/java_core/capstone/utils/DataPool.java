package com.ndt.assignment.java_core.capstone.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import com.ndt.assignment.java_core.capstone.entity.*;
import com.ndt.assignment.java_core.capstone.entity.GiamDoc;
import com.ndt.assignment.java_core.capstone.entity.NhanVien;
import com.ndt.assignment.java_core.capstone.entity.TruongPhong;


public class DataPool {
    private final String[] names = new String[]{"A", "B", "C", "D", "E"};

    private final String[] idPrefixes = new String[]{
        "BE", "DE", "FE",
        "DA", "DS", "PM"
    };

    private final String[] phonePrefixes = new String[]{
        "0931", "0919", "0933",
        "0126", "0831", "0120"
    };

    Random random = new Random();

    List<Map<Integer, Integer>> nameCounter;

    Map<Integer, Integer> idCounter;


    public DataPool() {
        nameCounter = List.of(
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>()
        );

        nameCounter.forEach(ele -> {
            for (int i = 0; i < names.length; i++) {
                ele.put(i, 0);
            }
        });


        idCounter = new HashMap<>();

        for (int i = 0; i < idPrefixes.length; i++) {
            idCounter.put(i, 0);
        }
    }


    private String _getAndUpdate(
        Map<Integer, Integer> mapping,
        String prefix,
        String[] strLst
    ) {
        Integer idx = new Random().nextInt(names.length);

        String val = String.format("%s%s%s", prefix == null ? "" : prefix, strLst[idx], mapping.get(idx));

        mapping.put(idx, mapping.get(idx) + 1);
        return val;
    }


    private String getNhanVienName() {
        String nhanVienPrefix = "Nhan Vien ";
        return _getAndUpdate(nameCounter.getFirst(), nhanVienPrefix, names);
    }


    private String getTruongPhongName() {
        String truongPhongPrefix = "Truong Phong ";
        return _getAndUpdate(nameCounter.get(1), truongPhongPrefix, names);
    }


    private String getGiamDocName() {
        String giamDocPrefix = "Giam Doc ";
        return _getAndUpdate(nameCounter.getLast(), giamDocPrefix, names);
    }


    private String getId() {
        return _getAndUpdate(idCounter, null, idPrefixes);
    }


    private String getPhone() {
        StringBuilder sb = new StringBuilder();
        sb.append(phonePrefixes[random.nextInt(phonePrefixes.length)]);

        byte counter = 4;
        while (counter++ < 11) {
            sb.append(random.nextInt(0, 10));
        }
        return sb.toString();
    }


    public NhanVien getNhanVien() {
        return new NhanVien(
            getId(),
            getNhanVienName(),
            getPhone(),
            100.,
            random.nextInt(5, 31)
        );
    }


    public TruongPhong getTruongPhong() {
        return new TruongPhong(
            getId(),
            getTruongPhongName(),
            getPhone(),
            200.,
            random.nextInt(5, 31)
        );
    }


    public GiamDoc getGiamDoc() {
        MathContext mc = new MathContext(2);
        return new GiamDoc(
            getId(),
            getGiamDocName(),
            getPhone(),
            300.,
            random.nextInt(5, 31),
            new BigDecimal(random.nextDouble(0., 1.), mc).doubleValue()
        );
    }
}
