public class TeacherData {
    private static int idCounter = 1;
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

}
