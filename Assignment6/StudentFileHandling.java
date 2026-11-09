
import java.io.*;

public class StudentFileHandling {
    public static void main(String[] args) {

        // 1. Write student details using FileWriter
        try {
            FileWriter fw = new FileWriter("students.txt");

            fw.write("101, Rahul, 85\n");
            fw.write("102, Priya, 90\n");
            fw.write("103, Amit, 78\n");

            fw.close();

            System.out.println("Student records written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // 2. Read student details using FileReader
        try {
            FileReader fr = new FileReader("students.txt");

            int ch;
            System.out.println("\nStudent Records:");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // 3. Copy binary file using byte streams
        try {
            FileOutputStream fos = new FileOutputStream("binary_copy.dat");
            FileInputStream fis = new FileInputStream("binary.dat");

            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();

            System.out.println("\nBinary file copied successfully.");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
