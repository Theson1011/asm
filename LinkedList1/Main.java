package LinkedList1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Giang
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyList ml = new MyList();

     
        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter details for student " + i + ":");

            int id = -1;
            while (id < 0) {
                try {
                    System.out.print("Enter ID (must be a number): ");
                    String idInput = scanner.nextLine();
                    if (!idInput.matches("\\d+")) {
                        throw new Exception("ID must be a number.");
                    }
                    id = Integer.parseInt(idInput);
                } catch (Exception e) {
                    System.out.println("Invalid input for ID. Please try again. " + e.getMessage());
                }
            }

           
            String name = "";
            while (true) { 
                try {
                    System.out.print("Enter Name (must not contain numbers or special characters): ");
                    name = scanner.nextLine();
                    if (!name.matches("[A-Za-z\\s]+")) {  
                        throw new Exception("Name must only contain letters and spaces.");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input for Name. Please try again. " + e.getMessage());
                }
            }

            double marks = -1;
            while (marks < 0) {
                try {
                    System.out.print("Enter Marks (must be a valid number): ");
                    String marksInput = scanner.nextLine();
                    if (!marksInput.matches("\\d+(\\.\\d+)?")) {
                        throw new Exception("Marks must be a valid number.");
                    }
                    marks = Double.parseDouble(marksInput);
                } catch (Exception e) {
                    System.out.println("Invalid input for Marks. Please try again. " + e.getMessage());
                }
            }

            
            Student student = new Student(id, name, marks);
            ml.add(student);
        }

        
         boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Edit a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Sort students");
            System.out.println("6. Search for a student");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("\nStudent List:");
                    ml.traverse();
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    Student newStudent = new Student(id, name, marks);
                    ml.add(newStudent);
                    System.out.println("New student added.");
                    break;
                case 3:
                    System.out.print("Enter ID of student to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();

                    ml.editStudent(editId, newName, newMarks);
                    break;
                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    ml.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Choose sorting option:");
                    System.out.println("1. Sort by Marks (Selection Sort)");
                    System.out.println("2. Sort by ID (Merge Sort)");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine(); 

                    if (sortOption == 1) {
                        ml.selectionSortByMarks();
                    } else if (sortOption == 2) {
                        ml.mergeSortById();
                    }
                    break;
                case 6:
                    System.out.println("Search by:");
                    System.out.println("1. ID");
                    System.out.println("2. Name");
                    System.out.println("3. Marks");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (searchOption) {
                        case 1:
                            System.out.print("Enter ID to search: ");
                            int searchId = scanner.nextInt();
                            Student foundById = ml.searchStudentById(searchId);
                            System.out.println(foundById != null ? foundById : "Student not found.");
                            break;
                        case 2:
                            System.out.print("Enter Name to search: ");
                            String searchName = scanner.nextLine();
                            Student foundByName = ml.searchStudentByName(searchName);
                            System.out.println(foundByName != null ? foundByName : "Student not found.");
                            break;
                        case 3:
                            System.out.print("Enter Marks to search: ");
                            double searchMarks = scanner.nextDouble();
                            Student foundByMarks = ml.searchStudentByMarks(searchMarks);
                            System.out.println(foundByMarks != null ? foundByMarks : "Student not found.");
                            break;
                    }
                    break;
                case 7:
                    running = false;
                    break;
            }
        }

        
        System.out.println("\nStudent List:");
        ml.traverse();

        scanner.close();
    }
}
