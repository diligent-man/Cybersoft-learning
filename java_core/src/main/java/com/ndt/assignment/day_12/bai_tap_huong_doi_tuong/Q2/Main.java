package com.ndt.assignment.day_12.bai_tap_huong_doi_tuong.Q2;

import java.util.*;
import java.math.*;


public class Main {
    static final DataPool dataPool = new DataPool();

    static final List<Student> students = new ArrayList<>();

    private static final String prompt = """
        Selection your option to execute:
            1/ Add new student to list
            2/ Compute GPA of all students
            3/ Sort students by GPA
            4/ Get highest GPA student
            5/ Get lowest GPA student
            6/ Find student by name
            7/ Find student by ID
            8/ Delete student by ID
            9/ Exit
        """;


    static void _addStudent(Scanner sc) {
        System.out.println("Enter student id: ");
        String id = sc.nextLine();
        id = id.isEmpty() ? dataPool.getName() : id;

        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        name = name.isEmpty() ? dataPool.getId() : name;

        String tmp;
        Random randomizer = new Random();
        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);

        System.out.println("Enter student math score: ");
        tmp = sc.nextLine();
        double math = tmp.isEmpty() ? new BigDecimal(randomizer.nextDouble(0, 10), mc).doubleValue() : Double.parseDouble(tmp);

        System.out.println("Enter student physics score: ");
        tmp = sc.nextLine();
        double physics = tmp.isEmpty() ? new BigDecimal(randomizer.nextDouble(0, 10), mc).doubleValue() : Double.parseDouble(tmp);

        System.out.println("Enter student chemistry score: ");
        tmp = sc.nextLine();
        double chemistry = tmp.isEmpty() ? new BigDecimal(randomizer.nextDouble(0, 10), mc).doubleValue() : Double.parseDouble(tmp);

        Map<String, Double> scores = new HashMap<>();
        scores.put("math", math);
        scores.put("physics", physics);
        scores.put("chemistry", chemistry);

        Student student = new Student(id, name, scores);

        System.out.println(student);
        students.add(student);
    }


    static void _computeGpaOfAll() {
        if (students.isEmpty()) {
            System.out.println("No student in list to compute GPA");
        } else {
            students.parallelStream().forEach(st -> {
                System.out.printf("GPA of %s is: %.2f\n", st.getName(), st.getAverageScore());
            });
        }
        System.out.println();
        // System.out.printf("This student is ranked as \"%s\"\n\n\n", student.rankStudent());
    }


    static void _sortByGpa() {
        if (students.isEmpty()) {
            System.out.println("No student in list to sort");
        } else {
            students.sort(Comparator.comparingDouble(Student::getAverageScore));
            System.out.println("After desceding sorting by GPA:");
            students.forEach(st -> System.out.printf("\t%s\n", st));
        }
        System.out.println();
    }


    static void _getStudentByGpa(boolean getHighest) {
        if (students.isEmpty()) {
            System.out.println("No student in list to get student by GPA");
        } else {
            Comparator<Student> comparator = getHighest ? Comparator.comparingDouble(Student::getAverageScore).reversed() : Comparator.comparingDouble(Student::getAverageScore);

            Student student = students.parallelStream()
                .sorted(comparator)
                .limit(1)
                .findFirst()
                .orElse(null);

            System.out.printf("Student with %s GPA is: %s\n",
                getHighest ? "highest" : "lowest",
                student
            );
            System.out.println();
        }
    }


    static void _findStudent(String name, boolean isId) {
        if (students.isEmpty()) {
            System.out.println("No student in list to find");
        } else {
            Student student = students.parallelStream()
                .filter(st -> isId ? st.getId().equals(name) : st.getName().equals(name))
                .findFirst()
                .orElse(null);

            System.out.println("Finding result" + (student == null ? "Student not found" : student));
        }
        System.out.println();
    }


    static void _deleteStudent(String name, boolean isId) {
        if (students.isEmpty()) {
            System.out.println("No student in list to delete");
        } else {
            Student student = students.parallelStream()
                .filter(st -> isId ? st.getId().equals(name) : st.getName().equals(name))
                .findFirst()
                .orElse(null);

            if (student == null) {
                System.out.println("Student not found !");
            } else {
                students.remove(student);
                System.out.printf("Student %s is removed !", student.getName());
            }
        }
    }


    static void main() {
        Scanner sc = new Scanner(System.in);
        String opt;

        while (true) {
            System.out.println(prompt);
            opt = sc.nextLine();

            switch (opt) {
                case "1" -> _addStudent(sc);
                case "2" -> _computeGpaOfAll();
                case "3" -> _sortByGpa();
                case "4" -> _getStudentByGpa(true);
                case "5" -> _getStudentByGpa(false);
                case "6" -> _findStudent("Nguyen Van A0", true);
                case "7" -> _findStudent("BA0", false);
                case "8" -> _deleteStudent("Nguyen Van A0", false);
                case "9" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Invalid option, select again !");
                    System.out.print(prompt);
                    opt = sc.nextLine();
                }
            }
        }
    }
}
