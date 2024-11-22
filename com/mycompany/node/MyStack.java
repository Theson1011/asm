/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.node;

import java.util.ArrayList;

/**
 * Lớp MyStack quản lý danh sách sinh viên dưới dạng ngăn xếp (stack).
 * 
 * @author ADMIN
 */
public class MyStack {
    private Node top;

    // Constructor để khởi tạo ngăn xếp rỗng
    public MyStack() {
        this.top = null;
    }

    // Kiểm tra ngăn xếp rỗng
    public boolean isEmpty() {
        return top == null;
    }

    // Thêm một phần tử vào ngăn xếp
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    // Xóa phần tử đầu tiên khỏi ngăn xếp
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            Student poppedStudent = top.data;
            top = top.next;
            return poppedStudent;
        }
    }

    // Xem phần tử đầu tiên của ngăn xếp
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return top.data;
        }
    }

    // Hiển thị toàn bộ sinh viên trong ngăn xếp
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    // Sửa thông tin sinh viên theo ID
    public void editStudent(String id, String newName, double newMarks) {
        Node current = top;
        while (current != null) {
            if (current.data.getId().equals(id)) {
                current.data.setName(newName);              
                current.data.setMarks(newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Tìm kiếm sinh viên theo ID
    // Tìm kiếm sinh viên theo ID và trả về đối tượng Student
    public Student searchStudentById(String id) {
        Node current = top;

        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) {
                return current.data; // Trả về sinh viên nếu tìm thấy
            }
            current = current.next;
        }

        System.out.println("No student found with ID: " + id);
        return null; // Trả về null nếu không tìm thấy
    }

    
    // Tìm kiếm sinh viên theo điểm
    public void searchStudentByMarks(double marks) {
        boolean found = false;
        Node current = top;

        while (current != null) {
            if (current.data.getMarks() == marks) {
                System.out.println("Student found: " + current.data);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No student found with marks: " + marks);
        }
    }

    // Tìm kiếm sinh viên theo tên
    public void searchStudentByName(String name) {
        boolean found = false;
        Node current = top;
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name)) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No student found with the name: " + name);
        }
    }
    
    
    

    // Xóa sinh viên theo ID
    public void deleteStudent(String id) {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        // Nếu phần tử cần xóa là phần tử đầu tiên
        if (top.data.getId().equals(id)) {
            top = top.next;
            System.out.println("Student with ID " + id + " has been deleted.");
            return;
        }

        Node current = top;
        while (current.next != null) {
            if (current.next.data.getId().equals(id)) {
                current.next = current.next.next;
                System.out.println("Student with ID " + id + " has been deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Sắp xếp ngăn xếp theo ID (Bubble Sort)
    public void sortStackById() {
        if (isEmpty()) return;

        // Chuyển stack sang danh sách để dễ sắp xếp
        ArrayList<Student> list = new ArrayList<>();
        while (!isEmpty()) {
            list.add(pop());
        }

        // Sắp xếp danh sách bằng Bubble Sort dựa trên ID
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getId().compareTo(list.get(j + 1).getId()) > 0) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        // Đẩy các phần tử đã sắp xếp lại vào stack
        for (int i = list.size() - 1; i >= 0; i--) {
            push(list.get(i));
        }
    }

    // Sắp xếp ngăn xếp theo điểm (Quick Sort)
    public void sortStackByMarks() {
        if (isEmpty()) return;

        // Chuyển stack sang danh sách để dễ sắp xếp
        ArrayList<Student> list = new ArrayList<>();
        while (!isEmpty()) {
            list.add(pop());
        }

        // Sắp xếp danh sách bằng Quick Sort dựa trên điểm
        quickSortByMarks(list, 0, list.size() - 1);

        // Đẩy các phần tử đã sắp xếp lại vào stack
        for (int i = list.size() - 1; i >= 0; i--) {
            push(list.get(i));
        }
    }

    // Quick Sort Helper Method
    private void quickSortByMarks(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortByMarks(list, low, pivotIndex - 1);
            quickSortByMarks(list, pivotIndex + 1, high);
        }
    }

    // Partition Method cho Quick Sort
    private int partition(ArrayList<Student> list, int low, int high) {
        double pivot = list.get(high).getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getMarks() <= pivot) {
                i++;
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}



