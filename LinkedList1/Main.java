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

        // Nhập dữ liệu cho 3 học sinh từ bàn phím
        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter details for student " + i + ":");

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa sau khi nhập số

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng thừa sau khi nhập số

            // Tạo đối tượng Student và thêm vào danh sách
            Student student = new Student(id, name, grade);
            ml.add(student);
        }
        
         boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Edit a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Sort students by marks");
            System.out.println("6. Search for a student by ID");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.println("\nStudent List:");
                    ml.traverse();
                    break;
                case 2:  // Thêm chức năng thêm học sinh
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
                    ml.sortStudents();
                    System.out.println("Students sorted by marks in descending order.");
                    break;
                case 6:
                    System.out.print("Enter ID of student to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    Student foundStudent = ml.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }

        // Duyệt và in nội dung của danh sách
        System.out.println("\nStudent List:");
        ml.traverse();

        scanner.close();
    }
}

