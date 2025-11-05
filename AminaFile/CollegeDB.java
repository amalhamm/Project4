package org.example;

import java.sql.*;
import java.util.ArrayList;

public class CollegeDB {
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:college.db";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    public static void updateStudent(Student student){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update student set FirstName = ?, LastName = ?, Major = ?, GPA = ? where ID = ?");

            // first value is index 1, it's ok to cry
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setDouble(4, student.getGpa());
            preparedStatement.setInt(5, student.getID());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Student> getStudent(int id){
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Student where id = ?");

            preparedStatement.setInt(1, id);

            ResultSet studentsQuery = preparedStatement.executeQuery();

            while (studentsQuery.next()) {
                String firstName = studentsQuery.getString("FirstName");
                String lastName = studentsQuery.getString("LastName");
                String major = studentsQuery.getString("Major");
                double gpa = studentsQuery.getDouble("GPA");

                students.add(new Student(id, firstName, lastName, major, gpa));
            }
            studentsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return students;
    }

    public static ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet studentsQuery = statement.executeQuery(
                    "SELECT * FROM Student");

            while (studentsQuery.next()) {
                int id = studentsQuery.getInt("ID");
                String firstName = studentsQuery.getString("FirstName");
                String lastName = studentsQuery.getString("LastName");
                String major = studentsQuery.getString("Major");
                double gpa = studentsQuery.getDouble("GPA");

                students.add(new Student(id, firstName, lastName, major, gpa));
            }
            studentsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return students;
    }

    public static void addStudent(Student student){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Student ( FirstName, LastName, Major, GPA ) values ( ?, ?, ?, ? )");

            // first value is index 1, it's ok to cry
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setDouble(4, student.getGpa());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void addEnrollment(Enrollment enrollment){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Enrollment ( StudentID, SectionID, CourseName, CourseSemester ) values ( ?, ?, ?, ? )");

            preparedStatement.setInt(1, enrollment.getStudentID());
            preparedStatement.setInt(2, enrollment.getSectionID());
            preparedStatement.setString(3, enrollment.getCourseName());
            preparedStatement.setString(4, enrollment.getCourseSemester());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Enrollment> getEnrollments(){
        ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet enrollmentsQuery = statement.executeQuery(
                    "SELECT * FROM Enrollment");

            while (enrollmentsQuery.next()) {
                int ID = enrollmentsQuery.getInt("ID");
                int StudentID = enrollmentsQuery.getInt("StudentID");
                int SectionID = enrollmentsQuery.getInt("SectionID");
                String CourseName = enrollmentsQuery.getString("CourseName");
                String CourseSemester = enrollmentsQuery.getString("CourseSemester");

                enrollments.add(new Enrollment(ID, StudentID, SectionID, CourseName, CourseSemester));
            }
            enrollmentsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return enrollments;
    }

    public static ArrayList<Enrollment> getEnrollmentsByStudent(int StudentID){
        ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Enrollment where StudentID = ?");

            preparedStatement.setInt(1, StudentID);

            ResultSet enrollmentsQuery = preparedStatement.executeQuery();

            while (enrollmentsQuery.next()) {
                int ID = enrollmentsQuery.getInt("ID");
                int SectionID = enrollmentsQuery.getInt("SectionID");
                String CourseName = enrollmentsQuery.getString("CourseName");
                String CourseSemester = enrollmentsQuery.getString("CourseSemester");

                enrollments.add(new Enrollment(ID, StudentID, SectionID, CourseName, CourseSemester));
            }
            enrollmentsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return enrollments;
    }

    public static Enrollment getEnrollment(int ID){
        Enrollment enrollment = null;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Enrollment where ID = ?");

            preparedStatement.setInt(1, ID);

            ResultSet enrollmentsQuery = preparedStatement.executeQuery();

            if (enrollmentsQuery.next()) {
                int StudentID = enrollmentsQuery.getInt("StudentID");
                int SectionID = enrollmentsQuery.getInt("SectionID");
                String CourseName = enrollmentsQuery.getString("CourseName");
                String CourseSemester = enrollmentsQuery.getString("CourseSemester");

                enrollment = new Enrollment(ID, StudentID, SectionID, CourseName, CourseSemester);
            }
            enrollmentsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return enrollment;
    }

    public static void updateEnrollment(Enrollment enrollment){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update Enrollment set StudentID = ?, SectionID = ?, CourseName = ?, CourseSemester = ? where ID = ?");

            preparedStatement.setInt(1, enrollment.getStudentID());
            preparedStatement.setInt(2, enrollment.getSectionID());
            preparedStatement.setString(3, enrollment.getCourseName());
            preparedStatement.setString(4, enrollment.getCourseSemester());
            preparedStatement.setInt(5, enrollment.getID());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void deleteEnrollment(int ID){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from Enrollment where ID = ?");

            preparedStatement.setInt(1, ID);

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    public static void init(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("PRAGMA foreign_keys = ON");
            statement.execute("CREATE TABLE IF NOT EXISTS Enrollment (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "StudentID INTEGER NOT NULL," +
                    "SectionID INTEGER NOT NULL," +
                    "CourseName TEXT NOT NULL," +
                    "CourseSemester TEXT NOT NULL," +
                    "FOREIGN KEY (StudentID) REFERENCES Student(ID)" +
                    ")");
            connection.close();
            System.out.println("Enrollment table is created or previously exists.");
        } catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

}