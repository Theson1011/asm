/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.node;

/**
 *
 * @author ADMIN
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap thong tin cho 3 hoc sinh:");

        for (int i = 0; i < 3; i++) {
            String id;
            String name;
            double marks;

            // Nhập ID là số
            while (true) {
                try {
                    System.out.print("nhap id hoc sinh : ");
                    id = scanner.nextLine();

                    if (id.matches("\\d+")) { // Kiểm tra nếu ID chỉ chứa số
                        break; // Thoát vòng lặp nếu đúng
                    } else {
                        System.out.println("Error: ID can only contain numbers. Please re-enter..");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Please re-enter a valid ID.");
                }
            }

            // Nhập tên là chữ
            while (true) {
                try {
                    System.out.print("Enter student name : ");
                    name = scanner.nextLine();

                    if (name.matches("[a-zA-Z ]+")) { // Kiểm tra nếu tên chỉ chứa chữ cái và khoảng trắng
                        break; // Thoát vòng lặp nếu đúng
                    } else {
                        System.out.println("Error: Name can only contain letters. Please re-enter..");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Please re-enter a valid name.");
                }
            }

            // Nhập điểm
            while (true) {
                try {
                    System.out.print("Enter Score: ");
                    marks = scanner.nextDouble();
                    scanner.nextLine(); // Xóa ký tự dòng mới

                    if (marks >= 0 && marks <= 10) {
                        break; // Thoát vòng lặp nếu điểm hợp lệ
                    } else {
                        System.out.println("Error: Score must be between 0 and 10. Please re-enter.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please re-enter score");
                    scanner.nextLine(); // Xóa nhập liệu không hợp lệqưdefvdrg
                }
            }

            stack.push(new Student(id, name, marks));
        }

        // Menu chức năng
        // Menu chức năng
while (true) {
    int choice = 0; // Biến để lưu tùy chọn
    while (true) { // Vòng lặp để đảm bảo chỉ nhập giá trị hợp lệ
        try {
            System.out.println("\nMenu:");
            System.out.println("1. Hiển thị danh sách học sinh");
            System.out.println("2. Thêm học sinh");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Sắp xếp học sinh");
            System.out.println("6. Tìm kiếm học sinh");
            System.out.println("7. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa ký tự dòng mới

            // Kiểm tra nếu lựa chọn nằm trong khoảng hợp lệ
            if (choice >= 1 && choice <= 7) {
                break; // Thoát vòng lặp nếu hợp lệ
            } else {
                System.out.println("Lỗi: Chỉ được chọn từ 1 đến 7. Vui lòng nhập lại.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên từ 1 đến 7.");
            scanner.nextLine(); // Xóa dữ liệu không hợp lệ
        }
    }

    // Xử lý từng lựa chọn
    switch (choice) {
        case 1:
            System.out.println("Danh sách học sinh:");
            stack.display();
            break;

        case 2:
            // Thêm học sinh mới
            String id, name;
            double marks;

            // Nhập ID là số
            while (true) {
                System.out.print("Nhập ID học sinh : ");
                id = scanner.nextLine();

                if (id.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Lỗi: ID chỉ được chứa số. Vui lòng nhập lại.");
                }
            }

            // Nhập tên là chữ
            while (true) {
                System.out.print("Nhập tên học sinh : ");
                name = scanner.nextLine();

                if (name.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("Lỗi: Tên chỉ được chứa chữ cái. Vui lòng nhập lại.");
                }
            }

            // Nhập điểm
            while (true) {
                System.out.print("Nhập điểm: ");
                marks = scanner.nextDouble();
                scanner.nextLine(); // Xóa ký tự dòng mới

                if (marks >= 0 && marks <= 10) {
                    break;
                } else {
                    System.out.println("Lỗi: Điểm phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
                }
            }

            stack.push(new Student(id, name, marks));
            System.out.println("Học sinh đã được thêm.");
            break;

        case 3:
            // Chỉnh sửa thông tin học sinh
            System.out.print("Nhập ID của học sinh cần sửa: ");
            String editId = scanner.nextLine();
            System.out.print("Nhập tên mới: ");
            String newName = scanner.nextLine();
            System.out.print("Nhập điểm mới: ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Xóa ký tự dòng mới

            stack.editStudent(editId, newName, newMarks);
            break;

        case 4:
            // Xóa học sinh
            System.out.print("Nhập ID của học sinh cần xóa: ");
            String deleteId = scanner.nextLine();
            stack.deleteStudent(deleteId);
            System.out.println("Đã xóa học sinh.");
            break;

        case 5:
            System.out.println("Chọn tiêu chí sắp xếp:");
            System.out.println("1. Theo ID");
            System.out.println("2. Theo điểm");
            int sortChoice = scanner.nextInt();
            scanner.nextLine(); // Xóa ký tự dòng mới

            if (sortChoice == 1) {
                stack.sortStackById();
                System.out.println("Danh sách học sinh đã được sắp xếp theo ID:");
            } else if (sortChoice == 2) {
                stack.sortStackByMarks();
                System.out.println("Danh sách học sinh đã được sắp xếp theo điểm:");
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
            stack.display();
            break;

        case 6:
        System.out.println("Chọn tiêu chí tìm kiếm:");
        System.out.println("1. Tìm kiếm theo ID");
        System.out.println("2. Tìm kiếm theo tên");
        System.out.println("3. Tìm kiếm theo điểm");
        int searchChoice = 0;

        // Kiểm tra nhập liệu cho tùy chọn
        while (true) {
            try {
                searchChoice = scanner.nextInt();
                scanner.nextLine(); // Xóa ký tự dòng mới
                if (searchChoice >= 1 && searchChoice <= 3) {
                    break;
                } else {
                    System.out.println("Lỗi: Chỉ được chọn từ 1 đến 3. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên từ 1 đến 3.");
                scanner.nextLine(); // Xóa dữ liệu không hợp lệ
            }
        }

        switch (searchChoice) {
            case 1:
                // Tìm kiếm theo ID
                String searchId;
                while (true) {
                    System.out.print("Nhập ID của học sinh cần tìm: ");
                    searchId = scanner.nextLine();
                    if (searchId.matches("\\d+")) { // Kiểm tra nếu ID chỉ chứa số
                        break;
                    } else {
                        System.out.println("Lỗi: ID chỉ được chứa số. Vui lòng nhập lại.");
                    }
                }

                Student foundById = stack.searchStudentById(searchId);
                if (foundById != null) {
                    System.out.println("Tìm thấy học sinh: " + foundById);
                } else {
                    System.out.println("Không tìm thấy học sinh với ID đã nhập.");
                }
                break;

            case 2:
                // Tìm kiếm theo tên
                String searchName;
                while (true) {
                    System.out.print("Nhập tên của học sinh cần tìm: ");
                    searchName = scanner.nextLine();
                    if (searchName.matches("[a-zA-Z ]+")) { // Kiểm tra nếu tên chỉ chứa chữ cái và khoảng trắng
                        break;
                    } else {
                        System.out.println("Lỗi: Tên chỉ được chứa chữ cái. Vui lòng nhập lại.");
                    }
                }

                stack.searchStudentByName(searchName);
                break;

            case 3:
                // Tìm kiếm theo điểm
                stack.sortStackByMarks(); // Sắp xếp danh sách trước khi hiển thị
                System.out.println("Danh sách học sinh sắp xếp theo điểm từ thấp đến cao:");
                stack.display();

                System.out.print("Nhập điểm của học sinh cần tìm: ");
                double searchMarks = 0;

                while (true) {
                    try {
                        searchMarks = scanner.nextDouble();
                        scanner.nextLine(); // Xóa ký tự dòng mới
                        if (searchMarks >= 0 && searchMarks <= 10) {
                            break;
                        } else {
                            System.out.println("Lỗi: Điểm phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
                        scanner.nextLine(); // Xóa dữ liệu không hợp lệ
                    }
                }

                stack.searchStudentByMarks(searchMarks);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        break;


        case 7:
            // Thoát
            System.out.println("Thoát chương trình.");
            scanner.close();
            return;

        default:
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
    }
}

    }
}


        
        

//        // In nội dung của ngăn xếp
//        System.out.println("Current Stack:");
//        stack.display();
//
//        // Lấy phần tử đầu tiên (pop) khỏi ngăn xếp
//        System.out.println("\nPopping one element:");
//        System.out.println(stack.pop());
//
//        // In ngăn xếp sau khi pop
//        System.out.println("\nStack after pop:");
//        stack.display();
//
//        // Xem phần tử đầu tiên (peek)
//        System.out.println("\nPeek top element:");
//        System.out.println(stack.peek());

       
