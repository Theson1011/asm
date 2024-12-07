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

        System.out.println("Enter information for 3 students:");

        for (int i = 0; i < 3; i++) {
            String id;
            String name;
            double marks;

            // Enter ID as a number
            while (true) {
                try {
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();

                    if (id.matches("\\d+")) { // Check if ID contains only numbers
                        break; // Exit loop if valid
                    } else {
                        System.out.println("Error: ID can only contain numbers. Please re-enter.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Please re-enter a valid ID.");
                }
            }

            // Enter name as letters
            while (true) {
                try {
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();

                    if (name.matches("[a-zA-Z ]+")) { // Check if name contains only letters and spaces
                        break; // Exit loop if valid
                    } else {
                        System.out.println("Error: Name can only contain letters. Please re-enter.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Please re-enter a valid name.");
                }
            }

            // Enter score
            while (true) {
                try {
                    System.out.print("Enter score: ");
                    marks = scanner.nextDouble();
                    scanner.nextLine(); // Clear newline character

                    if (marks >= 0 && marks <= 10) {
                        break; // Exit loop if valid
                    } else {
                        System.out.println("Error: Score must be between 0 and 10. Please re-enter.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please re-enter a valid score.");
                    scanner.nextLine(); // Clear invalid input
                }
            }

            stack.push(new Student(id, name, marks));
        }

        // Function menu
        while (true) {
            int choice = 0; // Variable to store user's choice
            while (true) { // Loop to ensure valid input
                try {
                    System.out.println("\nMenu:");
                    System.out.println("1. Display student list");
                    System.out.println("2. Add a student");
                    System.out.println("3. Edit student information");
                    System.out.println("4. Delete a student");
                    System.out.println("5. Sort students");
                    System.out.println("6. Search for a student");
                    System.out.println("7. Exit");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Clear newline character

                    // Check if the choice is valid
                    if (choice >= 1 && choice <= 7) {
                        break; // Exit loop if valid
                    } else {
                        System.out.println("Error: Only options 1 to 7 are valid. Please re-enter.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter an integer from 1 to 7.");
                    scanner.nextLine(); // Clear invalid input
                }
            }

            // Handle each choice
            switch (choice) {
                case 1:
                    System.out.println("Student list:");
                    stack.display();
                    break;

                case 2:
                    // Add a new student
                    String id, name;
                    double marks;

                    // Enter ID as a number
                    while (true) {
                        System.out.print("Enter student ID: ");
                        id = scanner.nextLine();

                        if (id.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("Error: ID can only contain numbers. Please re-enter.");
                        }
                    }

                    // Enter name as letters
                    while (true) {
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();

                        if (name.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Error: Name can only contain letters. Please re-enter.");
                        }
                    }

                    // Enter score
                    while (true) {
                        System.out.print("Enter score: ");
                        marks = scanner.nextDouble();
                        scanner.nextLine(); // Clear newline character

                        if (marks >= 0 && marks <= 10) {
                            break;
                        } else {
                            System.out.println("Error: Score must be between 0 and 10. Please re-enter.");
                        }
                    }

                    stack.push(new Student(id, name, marks));
                    System.out.println("Student has been added.");
                    break;

                case 3:
                    // Edit student information
                    System.out.print("Enter the ID of the student to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine(); // Clear newline character

                    stack.editStudent(editId, newName, newMarks);
                    break;

                case 4:
                    // Delete a student
                    System.out.print("Enter the ID of the student to delete: ");
                    String deleteId = scanner.nextLine();
                    stack.deleteStudent(deleteId);
                    System.out.println("Student has been deleted.");
                    break;

                case 5:
                    System.out.println("Choose sorting criteria:");
                    System.out.println("1. By ID");
                    System.out.println("2. By score");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear newline character

                    if (sortChoice == 1) {
                        stack.sortStackById();
                        System.out.println("Student list sorted by ID:");
                    } else if (sortChoice == 2) {
                        stack.sortStackByMarks();
                        System.out.println("Student list sorted by score:");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    stack.display();
                    break;

                case 6:
                    System.out.println("Choose search criteria:");
                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by name");
                    System.out.println("3. Search by score");
                    int searchChoice = 0;

                    while (true) {
                        try {
                            searchChoice = scanner.nextInt();
                            scanner.nextLine(); // Clear newline character
                            if (searchChoice >= 1 && searchChoice <= 3) {
                                break;
                            } else {
                                System.out.println("Error: Only options 1 to 3 are valid. Please re-enter.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter an integer from 1 to 3.");
                            scanner.nextLine();
                        }
                    }

                    switch (searchChoice) {
                        case 1:
                            // Search by ID (linear search)
                            System.out.print("Enter the ID of the student to search for: ");
                            String searchId = scanner.nextLine();

                            Student foundById = stack.searchStudentById(searchId);
                            if (foundById != null) {
                                System.out.println("Student found: " + foundById);
                            } else {
                                System.out.println("No student found with the entered ID.");
                            }
                            break;

                        case 2:
                            // Search by name
                            System.out.print("Enter the name of the student to search for: ");
                            String searchName = scanner.nextLine();
                            stack.searchStudentByName(searchName);
                            break;

                        case 3:
                            // Search by score (binary search)
                            System.out.println("Student list (sorted by score):");
                            stack.sortStackByMarks(); // Sort and display list
                            stack.display();

                            System.out.print("Enter the score of the student to search for: ");
                            double searchMarks = 0;

                            while (true) {
                                try {
                                    searchMarks = scanner.nextDouble();
                                    scanner.nextLine(); // Clear newline character
                                    if (searchMarks >= 0 && searchMarks <= 10) {
                                        break;
                                    } else {
                                        System.out.println("Error: Score must be between 0 and 10. Please re-enter.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Please enter a valid score.");
                                    scanner.nextLine(); // Clear invalid input
                                }
                            }

                            // Call binary search method
                            System.out.println("\nSearch results:");
                            stack.binarySearchByMarks(searchMarks);
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
