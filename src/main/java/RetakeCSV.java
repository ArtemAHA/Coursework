import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RetakeCSV {
    public static void saveToCSV(List<TeacherData> teacherDataList, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("dataBaseRetake.csv"), append))) {
            for(TeacherData teacherData : teacherDataList) {
                if(Integer.parseInt(teacherData.getRating()) < 60) {
                    writer.write(teacherData.getId() + ","
                            + teacherData.getName() + ","
                            + teacherData.getLastName() + ","
                            + teacherData.getDiscepline() + ","
                            + teacherData.getDepartment() + ","
                            + teacherData.getDisceplineName() + ","
                            + teacherData.getDisceplineTime() + ","
                            + teacherData.getRating() + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while saving to CSV");
            e.printStackTrace();
        }
    }

    public static ArrayList<TeacherData> loadFromRetakeCSV() {
        ArrayList<TeacherData> teacherDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("dataBaseRetake.csv")))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                TeacherData teacherData = new TeacherData(data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                teacherDataList.add(teacherData);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading from CSV");
            e.printStackTrace();
        }

        return teacherDataList;
    }
}
