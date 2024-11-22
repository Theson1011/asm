package LinkedList1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Giang
 */
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
            p.print(); // Gọi phương thức in trong lớp Node
            p = p.next;
        }
    }

    // 1. Phương thức Edit
    public void editStudent(int id, String newName, double newMarks) {
        Node p = head;
        while (p != null) {
            if (p.data.getId() == id) { // Tìm Node chứa học sinh có ID tương ứng
                p.data.setName(newName);
                p.data.setMarks(newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
            p = p.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // 2. Phương thức Delete
    public void deleteStudent(int id) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        // Xóa nếu học sinh ở đầu danh sách
        if (head.data.getId() == id) {
            head = head.next;
            if (head == null) tail = null; // Nếu danh sách rỗng sau khi xóa
            System.out.println("Student with ID " + id + " has been deleted.");
            return;
        }

        // Tìm và xóa học sinh trong các Node tiếp theo
        Node p = head;
        while (p.next != null) {
            if (p.next.data.getId() == id) {
                p.next = p.next.next;
                if (p.next == null) tail = p; // Cập nhật tail nếu xóa phần tử cuối
                System.out.println("Student with ID " + id + " has been deleted.");
                return;
            }
            p = p.next;
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    // 3. Phương thức Sort
    public void sortStudents() {
        if (head == null || head.next == null) return; // Không cần sắp xếp nếu ít hơn 2 Node

        // Sắp xếp nổi bọt (Bubble Sort) cho danh sách liên kết
        for (Node i = head; i != null; i = i.next) {
            for (Node j = head; j.next != null; j = j.next) {
                if (j.data.getMarks() < j.next.data.getMarks()) { // Sắp xếp giảm dần theo điểm số
                    Student temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
        System.out.println("Students sorted by marks in descending order.");
    }

    // 4. Phương thức Search
    public Student searchStudent(int id) {
        Node p = head;
        while (p != null) {
            if (p.data.getId() == id) {
                return p.data;
            }
            p = p.next;
        }
        return null; // Trả về null nếu không tìm thấy học sinh
    }
}



