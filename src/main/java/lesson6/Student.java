package lesson6;

import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void nextCourse() {
        if (getAverageGrade() >= 3) {
            this.course++;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}

class StudentManager {
    private Set<Student> students;

    public StudentManager() {
        this.students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentsWithAverageGradeLessThan3() {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public void printStudents(int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student student1 = new Student("Иван Иванов", "123", 1, Arrays.asList(4, 5, 3));
        Student student2 = new Student("Петр Петров", "456", 2, Arrays.asList(2, 3, 2));
        Student student3 = new Student("Анна Смирнова", "789", 1, Arrays.asList(5, 5, 5));

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        manager.removeStudentsWithAverageGradeLessThan3();

        System.out.println("Студенты на 1 курсе:");
        manager.printStudents(1);

        student1.nextCourse();
        System.out.println("Студенты на 2 курсе:");
        manager.printStudents(2);
    }
}
