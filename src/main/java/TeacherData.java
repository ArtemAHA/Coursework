public class TeacherData {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String lastName;
    private String discepline;
    private String department;
    private String disceplineName;
    private String disceplineTime;

    public TeacherData(String name, String lastName, String discepline, String department, String disceplineName, String disceplineTime) {
        this.id = idCounter++;
        this.name = name;
        this.lastName = lastName;
        this.discepline = discepline;
        this.department = department;
        this.disceplineName = disceplineName;
        this.disceplineTime = disceplineTime;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDiscepline() {
        return discepline;
    }

    public String getDepartment() {
        return department;
    }

    public String getDisceplineName() {
        return disceplineName;
    }

    public String getDisceplineTime() {
        return disceplineTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDiscepline(String discepline) {
        this.discepline = discepline;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDisceplineName(String disceplineName) {
        this.disceplineName = disceplineName;
    }

    public void setDisceplineTime(String disceplineTime) {
        this.disceplineTime = disceplineTime;
    }

}
