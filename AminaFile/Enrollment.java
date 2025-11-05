package org.example;

public class Enrollment {
    private int ID;
    private int StudentID;
    private int SectionID;
    private String CourseName;
    private String CourseSemester;

    public Enrollment(int ID, int StudentID, int SectionID, String CourseName, String CourseSemester) {
        this.ID = ID;
        this.StudentID = StudentID;
        this.SectionID = SectionID;
        this.CourseName = CourseName;
        this.CourseSemester = CourseSemester;
    }

    public int getID() {
        return ID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public int getSectionID() {
        return SectionID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseSemester() {
        return CourseSemester;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public void setSectionID(int SectionID) {
        this.SectionID = SectionID;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setCourseSemester(String CourseSemester) {
        this.CourseSemester = CourseSemester;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "ID=" + ID +
                ", StudentID=" + StudentID +
                ", SectionID=" + SectionID +
                ", CourseName='" + CourseName + '\'' +
                ", CourseSemester='" + CourseSemester + '\'' +
                '}';
    }
}
