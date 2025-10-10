package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge1 {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Student Management System ===");

        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Find Top Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudents();
                case 3 -> calculateAverageGrade();
                case 4 -> findTopStudent();
                case 5 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();

        Student student = new Student(name, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("\n--- List of Students ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void calculateAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate average.");
            return;
        }

        double total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }

        double average = total / students.size();
        System.out.println("Average Grade: " + average);
    }

    private static void findTopStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to evaluate.");
            return;
        }

        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > top.getGrade()) {
                top = s;
            }
        }

        System.out.println("Top Student: " + top);
    }
}
