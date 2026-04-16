import java.io.*;
import java.util.*;

public class StudentCSV {

    static String fileName = "Students.csv";

    public static void main(String[] args) {

        try {
            createFile();
            display("After Create");

            insertStudents();
            display("After Insert");

            updateMarks();
            display("After Update");

            calculatePercentage();
            display("After Percentage Calculation");

            deleteStudent("2"); // delete Tina
            display("After Delete");

            saveFinalOutput();

            // Exception demonstration
            triggerException();

        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // CREATE
    static void createFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        bw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");
        bw.write("1,Neha,CSE,70,75,80,85,90,0\n");
        bw.write("2,Tina,IT,60,65,70,75,80,0\n");

        bw.close();
        System.out.println("File Created");
    }

    // INSERT
    static void insertStudents() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        bw.write("3,Preeti,ECE,50,55,60,0,0,0\n");
        bw.write("4,Arya,MECH,65,70,75,0,0,0\n");
        bw.write("5,Seema,CIVIL,80,85,90,0,0,0\n");

        bw.close();
        System.out.println("Students Inserted");
    }

    // UPDATE
    static void updateMarks() throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine();
        list.add(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[6].equals("0")) data[6] = "70";
            if (data[7].equals("0")) data[7] = "75";

            list.add(String.join(",", data));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : list) bw.write(l + "\n");
        bw.close();

        System.out.println("Marks Updated");
    }

    // CALCULATE PERCENTAGE
    static void calculatePercentage() throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine();
        list.add(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            int total = 0;
            for (int i = 3; i <= 7; i++) {
                total += Integer.parseInt(data[i]);
            }

            double percentage = total / 5.0;
            data[8] = String.format("%.2f", percentage);

            list.add(String.join(",", data));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : list) bw.write(l + "\n");
        bw.close();

        System.out.println("Percentage Calculated");
    }

    // DELETE
    static void deleteStudent(String id) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine();
        list.add(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!data[0].equals(id)) {
                list.add(line);
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : list) bw.write(l + "\n");
        bw.close();

        System.out.println("Student Deleted (Tina)");
    }

    // DISPLAY FUNCTION
    static void display(String stage) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        System.out.println("\n--- " + stage + " ---");

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    // SAVE FINAL OUTPUT
    static void saveFinalOutput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Students_Final.csv"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line + "\n");
        }

        br.close();
        bw.close();

        System.out.println("\nFinal output saved to Students_Final.csv");
    }

    // EXCEPTION DEMO
    static void triggerException() throws IOException {
        System.out.println("\nTriggering Exception...");
        BufferedReader br = new BufferedReader(new FileReader("WrongFile.csv"));
        br.readLine();
        br.close();
    }
}