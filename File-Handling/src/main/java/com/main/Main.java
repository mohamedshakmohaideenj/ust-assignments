package com.main;
import java.io.*;

public class Main {

    static String FILE_NAME = "students.csv";

    public static void main(String[] args) {

        writeCSV();                     // Assignment 1
        readCSV();                      // Assignment 2
        studentsAbove60();              // Assignment 3
        countRecords();                 // Assignment 4
        searchStudentByName("Anita");   // Assignment 5
        displayFailedStudents();        // Assignment 6
        calculateAverageMarks();        // Assignment 7
        copyPassedStudents();           // Assignment 8
        validateCSVData();              // Assignment 9
        displayTopper();                // Assignment 10
    }

    // Assignment 1: Write CSV File
    public static void writeCSV() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write("id,name,marks\n");
            fw.write("101,Ravi,78\n");
            fw.write("102,Anita,85\n");
            fw.write("103,Sunil,35\n");
            fw.write("104,Priya,92\n");
            fw.write("105,Aman,45\n");
            System.out.println("CSV file created successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Assignment 2: Read CSV File
    public static void readCSV() {
        System.out.println("All Student Records:");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(String.join(" | ", data));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Assignment 3: Students with Marks > 60
    public static void studentsAbove60() {
        System.out.println("Students with Marks > 60:");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[2]);
                if (marks > 60) {
                    System.out.println(line);
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Assignment 4: Count Records
    public static void countRecords() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            br.readLine(); // skip header
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("Total Number of Students: " + count + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Assignment 5: Search Student by Name
    public static void searchStudentByName(String name) {
        System.out.println("Search Result for '" + name + "':");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(name)) {
                    System.out.println(line);
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Assignment 6: Display Failed Students
    public static void displayFailedStudents() {
        System.out.println("Failed Students (Marks < 40):");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[2]);
                if (marks < 40) {
                    System.out.println(line);
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Assignment 7: Calculate Average Marks
    public static void calculateAverageMarks() {
        int sum = 0, count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                sum += Integer.parseInt(data[2]);
                count++;
            }
            System.out.println("Average Marks: " + (sum / count) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Assignment 8: Copy Passed Students
    public static void copyPassedStudents() {
        try (
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            FileWriter fw = new FileWriter("passed_students.csv")
        ) {
            fw.write("id,name,marks\n");
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[2]);
                if (marks >= 50) {
                    fw.write(line + "\n");
                }
            }
            System.out.println("Passed students copied to passed_students.csv\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Assignment 9: Validate CSV Data
    public static void validateCSVData() {
        System.out.println("Valid Records:");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    Integer.parseInt(data[2]);
                    System.out.println(line);
                } catch (NumberFormatException e) {
                    // ignore invalid records
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Assignment 10: Display Topper
    public static void displayTopper() {
        String topperName = "";
        int maxMarks = Integer.MIN_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[2]);
                if (marks > maxMarks) {
                    maxMarks = marks;
                    topperName = data[1];
                }
            }
            System.out.println("Topper: " + topperName + " with Marks: " + maxMarks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

