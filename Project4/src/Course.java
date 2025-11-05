public class Course {
    private int ID;
    private String department;
    private int num;
    private int title;
    private int course;

    public Course(int ID, String department, int num, int title, int course) {
        this.ID = ID;
        this.department = department;
        this.num = num;
        this.title = title;
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public int getTitle() {
        return title;
    }

    public int getNum() {
        return num;
    }

    public String getDepartment() {
        return department;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", department='" + department + '\'' +
                ", num=" + num +
                ", title=" + title +
                ", course=" + course +
                '}';
    }
}
