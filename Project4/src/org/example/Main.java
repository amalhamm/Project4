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

    public static Course getCourseInfo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter department, num, title, course");
        String text = keyboard.nextLine();
        String[] split = text.split(",");
        String dept = split[0].trim();
        int num = Integer.parseInt(split[1].trim());
        String title = split[2].trim();
        String courseName = split[3].trim();
        return new Course(0, dept, num, title, courseName);
    }

    public static Section getSectionInfo(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter courseID, facultyID, semester, day, startT, endT, modality");
        String text = keyboard.nextLine();
        String[] split = text.split(",");
        int courseID = Integer.parseInt(split[0].trim());
        int facultyID = Integer.parseInt(split[1].trim());
        String semester = split[2].trim();
        String day = split[3].trim();
        String startT = split[4].trim();
        String endT = split[5].trim();
        String modality = split[6].trim();
        return new Section(0, courseID, facultyID, semester, day, startT, endT, modality);
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while ( choice != 4 ) {

            System.out.println("Enter 1 to add, 2 to read, 3 to update, 4 to quit");
            choice = Integer.parseInt(keyboard.nextLine());

            if (choice == 1) {
                org.example.CollegeDB.addStudent(getStudentInfo());
            } else if (choice == 2) {
                ArrayList<Student> students = org.example.CollegeDB.getStudents();

                for (Student student : students) {
                    System.out.println(student);
                }

            }
            else if (choice == 3) {

                System.out.println("Enter ID of student to update");
                int id =  Integer.parseInt(keyboard.nextLine());

                ArrayList<Student> students = org.example.CollegeDB.getStudent(id);

                boolean foundStudent = false;
                // TODO - fix later to find just 1
                for ( Student student : students) {
                    if ( student.getID() == id ) {
                        System.out.println(student);
                        Student studentInfo = getStudentInfo();
                        studentInfo.setID(id);
                        org.example.CollegeDB.updateStudent(studentInfo);
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