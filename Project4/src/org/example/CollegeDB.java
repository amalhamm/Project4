package org.example;

import java.sql.*;
import java.util.ArrayList;

public class CollegeDB {
    private static Course course;

    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:college.db";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    public static void updateStudent(Student student) {
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
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Student> getStudent(int id) {
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
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return students;
    }

    public static ArrayList<Student> getStudents() {
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
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return students;
    }

    public static void addStudent(Student student) {
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
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }



    public static ArrayList<Course> getCourses(){
        ArrayList<Course> courses = new ArrayList<Course>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet coursesQuery = statement.executeQuery(
                    "SELECT * FROM Course");

            while (coursesQuery.next()) {
                int ID = coursesQuery.getInt("ID");
                String Department = coursesQuery.getString("Department");
                int Num = coursesQuery.getInt("Num");
                String Title = coursesQuery.getString("Title");
                String Course = coursesQuery.getString("Course");

                courses.add(new Course(ID, Department, Num, Title, Course));
            }
            coursesQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return courses;
    }

    public static ArrayList<Course> getCourse(int id){
        ArrayList<Course> courses = new ArrayList<Course>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Course where ID = ?");

            preparedStatement.setInt(1, id);

            ResultSet coursesQuery = preparedStatement.executeQuery();

            while (coursesQuery.next()) {
                String Department = coursesQuery.getString("Department");
                int Num = coursesQuery.getInt("Num");
                String Title = coursesQuery.getString("Title");
                String Course = coursesQuery.getString("Course");

                courses.add(new Course(id, Department, Num, Title, Course));
            }
            coursesQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return courses;
    }

    public static void updateCourse(Course course){
        CollegeDB.course = course;
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update Course set Department = ?, Num = ?, Title = ?, Course = ? where ID = ?");

            preparedStatement.setString(1, course.getDepartment());
            preparedStatement.setInt(2, course.getNum());
            preparedStatement.setString(3, course.getTitle());
            preparedStatement.setString(4, course.getCourse());
            preparedStatement.setInt(5, course.getID());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    // ========== SECTION METHODS ==========

    public static ArrayList<Section> getSections(){
        ArrayList<Section> sections = new ArrayList<Section>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet sectionsQuery = statement.executeQuery(
                    "SELECT * FROM Section");

            while (sectionsQuery.next()) {
                int id = sectionsQuery.getInt("ID");
                int courseID = sectionsQuery.getInt("CourseID");
                int facultyID = sectionsQuery.getInt("FacultyID");
                String semester = sectionsQuery.getString("Semester");
                String day = sectionsQuery.getString("Day");
                String startT = sectionsQuery.getString("StartT");
                String endT = sectionsQuery.getString("EndT");
                String modality = sectionsQuery.getString("Modality");

                sections.add(new Section(id, courseID, facultyID, semester, day, startT, endT, modality));
            }
            sectionsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return sections;
    }

    public static ArrayList<Section> getSection(int id){
        ArrayList<Section> sections = new ArrayList<Section>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Section where ID = ?");

            preparedStatement.setInt(1, id);

            ResultSet sectionsQuery = preparedStatement.executeQuery();

            while (sectionsQuery.next()) {
                int courseID = sectionsQuery.getInt("CourseID");
                int facultyID = sectionsQuery.getInt("FacultyID");
                String semester = sectionsQuery.getString("Semester");
                String day = sectionsQuery.getString("Day");
                String startT = sectionsQuery.getString("StartT");
                String endT = sectionsQuery.getString("EndT");
                String modality = sectionsQuery.getString("Modality");

                sections.add(new Section(id, courseID, facultyID, semester, day, startT, endT, modality));
            }
            sectionsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return sections;
    }

    public void updateSection(Section section){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update Section set CourseID = ?, FacultyID = ?, Semester = ?, Day = ?, StartT = ?, EndT = ?, Modality = ? where ID = ?");

            preparedStatement.setInt(1, section.getCourseID());
            preparedStatement.setInt(2, section.getFacultyID());
            preparedStatement.setString(3, section.getSemester());
            preparedStatement.setString(4, section.getDay());
            preparedStatement.setString(5, section.getStartT());
            preparedStatement.setString(6, section.getEndT());
            preparedStatement.setString(7, section.getModality());
            preparedStatement.setInt(8, section.getID());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}