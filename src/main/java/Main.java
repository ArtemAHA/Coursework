import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("dataBase.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("An error occurred while creating a file");
                e.printStackTrace();
            }
        }
        File file1 = new File("dataBaseRetake.csv");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (Exception e) {
                System.out.println("An error occurred while creating a file");
                e.printStackTrace();
            }
        }
        new Frame();
    }
}