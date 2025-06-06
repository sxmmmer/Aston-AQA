package org.sxmmer.Task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Алексей", "A1", 1, Arrays.asList(4, 3, 5)));
        students.add(new Student("Мария", "A1", 1, Arrays.asList(2, 2, 3)));
        students.add(new Student("Иван", "B2", 2, Arrays.asList(5, 5, 5)));
        students.add(new Student("Ольга", "C3", 3, Arrays.asList(1, 2, 2)));

        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);

        Student.deleteStudent(students);
        Student.transferStudent(students);

        System.out.println("\nПосле удаления и перевода на следующий курс:");
        students.forEach(System.out::println);

        System.out.println("\nСтуденты на 2 курсе:");
        Student.printStudents(students, 2);
    }
}
