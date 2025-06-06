package org.sxmmer.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Student {
    String name;
    String group;
    int course;
    List<Integer> marks;

    public Student(String name, String group, int course, List<Integer> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (группа: " + group + ", курс: " + course + ", оценки: " + marks + ")";
    }

    public static void deleteStudent(Set<Student> students) {
        List<Student> toRemove = new ArrayList<>();

        for (Student student : students) {
            int sum = 0;
            for (int mark : student.marks) {
                sum += mark;
            }
            double averageMark = (double) sum / student.marks.size();

            if (averageMark < 3) {
                toRemove.add(student);
            }
        }
        students.removeAll(toRemove);
    }

    public static void transferStudent(Set<Student> students) {
        for (Student student : students) {
            int sum = 0;
            for (int mark : student.marks) {
                sum += mark;
            }
            double averageMark = (double) sum / student.marks.size();

            if (averageMark > 3) {
                student.course = student.course + 1;
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }
}
