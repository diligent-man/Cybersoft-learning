package com.ndt.spring.assignment.day_41.search_spec.bt_jpa_1.q5;

import org.springframework.data.jpa.domain.Specification;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q5.StudentEntity;


public class StudentSpecs {
    public static Specification<StudentEntity> hasNameContainingIgnoreCase(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("name")), String.format("%%%s%%", name.toLowerCase()));
        };
    }


    public static Specification<StudentEntity> hasAgeBetween(
        Integer ageFrom, Integer ageTo
    ) {
        return (root, query, cb) -> cb.between(root.get("age"), ageFrom, ageTo);
    }


    public static Specification<StudentEntity> hasEmailEndsWith(String emailDomain) {
        return (root, query, cb) ->
            emailDomain == null || emailDomain.isBlank() ?
                null : cb.like(root.get("email"), "%" + emailDomain);
    }


    public static Specification<StudentEntity> build(String name, Integer ageFrom, Integer ageTo, String emailDomain) {
        return Specification.allOf(
            hasNameContainingIgnoreCase(name),
            hasAgeBetween(ageFrom, ageTo),
            hasEmailEndsWith(emailDomain)
        );
    }
}
