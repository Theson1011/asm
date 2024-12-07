/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The MyStack class manages a list of students in the form of a stack.
 * 
 * @author ADMIN
 */
public class MyStack {
    private Node top;

    // Constructor to initialize an empty stack
    public MyStack() {
        this.top = null;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push a new element onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode; 
    }

    // Pop the top element from the stack
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

    // Peek at the top element of the stack
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return top.data;
        }
    }

    // Display all students in the stack
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

    // Edit student information by ID
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

    // Search for a student by ID and return the Student object
    public Student searchStudentById(String id) {
        Node current = top; // Start from the top of the stack

        while (current != null) { // Traverse through the stack
            if (current.data.getId().equalsIgnoreCase(id)) {
                return current.data;
            }
            current = current.next; // Move to the next node
        }

        // If no match is found, return null
        System.out.println("No student found with ID: " + id);
        return null;
    }

    // Search for students by marks (Binary Search and display all matching students)
    public void binarySearchByMarks(double marks) {
        List<Student> students = new ArrayList<>();
        Node current = top;

        // Add all students to a temporary list
        while (current != null) {
            students.add(current.data);
            current = current.next;
        }

        // Sort the list for binary search
        students.sort(Comparator.comparingDouble(Student::getMarks));

        // Perform binary search
        int left = 0, right = students.size() - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            double midMarks = students.get(mid).getMarks();

            if (midMarks == marks) {
                found = true;
                System.out.println("Found students with marks " + marks + ":");

                // Display all students with the specified marks
                int i = mid;
                while (i >= 0 && students.get(i).getMarks() == marks) { // Search left
                    System.out.println(students.get(i));
                    i--;
                }

                i = mid + 1;
                while (i < students.size() && students.get(i).getMarks() == marks) { // Search right
                    System.out.println(students.get(i));
                    i++;
                }
                break;
            } else if (midMarks < marks) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("No students found with marks: " + marks);
        }
    }

    // Search for students by name
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

    // Delete a student by ID
    public void deleteStudent(String id) {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        // If the first element needs to be deleted
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

    // Sort the stack by ID (Bubble Sort)
    public void sortStackById() {
        if (isEmpty()) return;

        // Move stack to a list for sorting
        ArrayList<Student> list = new ArrayList<>();
        while (!isEmpty()) {
            list.add(pop());
        }

        // Sort the list using Bubble Sort based on ID
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getId().compareTo(list.get(j + 1).getId()) > 0) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        // Push the sorted elements back into the stack
        for (int i = list.size() - 1; i >= 0; i--) {
            push(list.get(i));
        }
    }

    // Sort the stack by marks (Quick Sort)
    public void sortStackByMarks() {
        if (isEmpty()) return;

        // Move stack to a list for sorting
        ArrayList<Student> list = new ArrayList<>();
        while (!isEmpty()) {
            list.add(pop());
        }

        // Sort the list using Quick Sort based on marks
        quickSortByMarks(list, 0, list.size() - 1);

        // Push the sorted elements back into the stack
        for (int i = list.size() - 1; i >= 0; i--) {
            push(list.get(i));
        }
    }

    // Helper method for Quick Sort
    private void quickSortByMarks(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortByMarks(list, low, pivotIndex - 1);
            quickSortByMarks(list, pivotIndex + 1, high);
        }
    }

    // Partition method for Quick Sort
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
