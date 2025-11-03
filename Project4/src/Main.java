package org.example;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.time.*;

public class Main {

    public static Student getStudentInfo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter firstname, lastname, major, gpa");
        String text = keyboard.nextLine();
        String[] split = text.split(",");
        String firstName = split[0].trim();
        String lastName = split[1].trim();
        String major = split[2].trim();
        double gpa = Double.parseDouble(split[3]);
        return new Student(0, firstName,lastName,major,gpa);
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while ( choice != 4 ) {

            System.out.println("Enter 1 to add, 2 to read, 3 to update, 4 to quit");
            choice = Integer.parseInt(keyboard.nextLine());

            if (choice == 1) {
                CollegeDB.addStudent(getStudentInfo());
            } else if (choice == 2) {
                ArrayList<Student> students = CollegeDB.getStudents();

                for (Student student : students) {
                    System.out.println(student);
                }

            }
            else if (choice == 3) {

                System.out.println("Enter ID of student to update");
                int id =  Integer.parseInt(keyboard.nextLine());

                ArrayList<Student> students = CollegeDB.getStudent(id);

                boolean foundStudent = false;
                // TODO - fix later to find just 1
                for ( Student student : students) {
                    if ( student.getID() == id ) {
                        System.out.println(student);
                        Student studentInfo = getStudentInfo();
                        studentInfo.setID(id);
                        CollegeDB.updateStudent(studentInfo);
                        foundStudent = true;
                        break;
                    }
                }
                if ( !foundStudent ) {
                    System.out.println("ID not found!");
                }
            }
        }



    }
}