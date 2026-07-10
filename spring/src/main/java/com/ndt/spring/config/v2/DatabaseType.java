package com.ndt.spring.config.v2;


import lombok.Getter;
import lombok.AllArgsConstructor;


@Getter
@AllArgsConstructor
public enum DatabaseType {
    DEFAULT("default"),

    JPA1Q1("bt-jpa1-q1");
    // JPA1Q2("bt-jpa1-q2");
    // JPA1Q3("bt-jpa1-q3"),
    // JPA1Q4("bt-jpa1-q4"),
    // JPA1Q5("bt-jpa1-q5"),
    // JPA1Q6("bt-jpa1-q6"),
    // JPA1Q7("bt-jpa1-q7"),
    // JPA1Q8("bt-jpa1-q8"),
    // JPA1Q9("bt-jpa1-q9"),
    // JPA1Q10("bt-jpa1-q10"),
    //
    // JPA2Q1("bt-jpa2-q1"),
    // JPA2Q2("bt-jpa2-q2"),
    // JPA2Q3("bt-jpa2-q3"),
    // JPA2Q4("bt-jpa2-q4"),
    // JPA2Q5("bt-jpa2-q5"),
    // JPA2Q6("bt-jpa2-q6"),
    // JPA2Q7("bt-jpa2-q7"),
    // JPA2Q8("bt-jpa2-q8"),
    // JPA2Q9("bt-jpa2-q9"),
    // JPA2Q10("bt-jpa2-q10"),
    //
    //
    // JPA3Q1("bt-jpa3-q1"),
    // JPA3Q2("bt-jpa3-q2"),
    // JPA3Q3("bt-jpa3-q3"),
    // JPA3Q4("bt-jpa3-q4"),
    // JPA3Q5("bt-jpa3-q5"),
    // JPA3Q6("bt-jpa3-q6"),
    // JPA3Q7("bt-jpa3-q7"),
    // JPA3Q8("bt-jpa3-q8"),
    // JPA3Q9("bt-jpa3-q9"),
    // JPA3Q10("bt-jpa3-q10");

    private final String name;
    }