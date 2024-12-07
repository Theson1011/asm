package LinkedList1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Giang
 */
import java.util.ArrayList;
import java.util.List;

public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void add(Student x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            p.print(); 
            p = p.next;
        }
    }

    // Edit student
    public void editStudent(int id, String newName, double newMarks) {
        Node p = head;
        while (p != null) {
            if (p.data.getId() == id) {
                p.data.setName(newName);
                p.data.setMarks(newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
            p = p.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete student
    public void deleteStudent(int id) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        if (head.data.getId() == id) {
            head = head.next;
            if (head == null) tail = null; 
            System.out.println("Student with ID " + id + " has been deleted.");
            return;
        }

        Node p = head;
        while (p.next != null) {
            if (p.next.data.getId() == id) {
                p.next = p.next.next;
                if (p.next == null) tail = p;
                System.out.println("Student with ID " + id + " has been deleted.");
                return;
            }
            p = p.next;
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    // Selection Sort 
    public void selectionSortByMarks() {
        if (head == null || head.next == null) return;

        for (Node i = head; i != null; i = i.next) {
            Node minNode = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.data.getMarks() < minNode.data.getMarks()) {
                    minNode = j;
                }
            }
            if (minNode != i) {
                Student temp = i.data;
                i.data = minNode.data;
                minNode.data = temp;
            }
        }
        System.out.println("Students sorted by marks in ascending order.");
    }

    // Merge Sort 
    public void mergeSortById() {
        if (head != null) {
            head = mergeSortByIdRecursive(head);
        }
        System.out.println("Students sorted by ID in ascending order.");
    }

    // Helper method for Merge Sort
    private Node mergeSortByIdRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSortByIdRecursive(node);
        Node right = mergeSortByIdRecursive(nextOfMiddle);

        return mergeById(left, right);
    }

    // Merge two sorted lists
    private Node mergeById(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.data.getId() <= right.data.getId()) {
            left.next = mergeById(left.next, right);
            return left;
        } else {
            right.next = mergeById(left, right.next);
            return right;
        }
    }

    // Get middle node for Merge Sort
    private Node getMiddle(Node node) {
        if (node == null) return node;

        Node slow = node;
        Node fast = node.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    // Linear search by ID
    public Student searchStudentById(int id) {
        Node p = head;
        while (p != null) {
            if (p.data.getId() == id) {
                return p.data;
            }
            p = p.next;
        }
        return null;
    }

    // Search by Name (Linear search)
    public Student searchStudentByName(String name) {
        Node p = head;
        while (p != null) {
            if (p.data.getName().equalsIgnoreCase(name)) {
                return p.data;
            }
            p = p.next;
        }
        return null;
    }

    // Binary search by Marks
    public Student searchStudentByMarks(double marks) {
        List<Student> students = new ArrayList<>();
        Node p = head;
        while (p != null) {
            students.add(p.data);
            p = p.next;
        }
        students.sort((s1, s2) -> Double.compare(s1.getMarks(), s2.getMarks()));

        int left = 0, right = students.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (students.get(mid).getMarks() == marks) {
                return students.get(mid);
            } else if (students.get(mid).getMarks() < marks) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}


