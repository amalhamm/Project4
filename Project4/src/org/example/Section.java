package org.example;

public class Section {
    private int ID;
    private int courseID;
    private int FacultyID;
    private String semester;
    private String day;
    private String startT;
    private String endT;
    private String modality;

    public Section(int ID, int courseID, int facultyID, String semester, String day, String startT, String endT, String modality) {
        this.ID = ID;
        this.courseID = courseID;
        FacultyID = facultyID;
        this.semester = semester;
        this.day = day;
        this.startT = startT;
        this.endT = endT;
        this.modality = modality;
    }

    public int getID() {
        return ID;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getFacultyID() {
        return FacultyID;
    }

    public String getSemester() {
        return semester;
    }

    public String getDay() {
        return day;
    }

    public String getStartT() {
        return startT;
    }

    public String getEndT() {
        return endT;
    }

    public String getModality() {
        return modality;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setFacultyID(int facultyID) {
        FacultyID = facultyID;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setStartT(String startT) {
        this.startT = startT;
    }

    public void setEndT(String endT) {
        this.endT = endT;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    @Override
    public String toString() {
        return "Section{" +
                "ID=" + ID +
                ", courseID=" + courseID +
                ", FacultyID=" + FacultyID +
                ", semester='" + semester + '\'' +
                ", day='" + day + '\'' +
                ", startT='" + startT + '\'' +
                ", endT='" + endT + '\'' +
                ", modality='" + modality + '\'' +
                '}';
    }
}
