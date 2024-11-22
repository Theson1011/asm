package LinkedList1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Giang
 */
public class Student {
    private int Id;
    private String name;
    private double Marks;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return Marks;
    }

    public void setMarks(double Marks) {
        this.Marks = Marks;
    }
    public Student(int Id , String name, double Marks){
        this.Id = Id;
        this.name = name;
        this.Marks = Marks;
    }
    // Phương thức tính toán rank dựa trên marks
    public String getRank() {
        if (Marks < 5.0) {
            return "Fail";
        } else if (Marks < 6.5) {
            return "Medium";
        } else if (Marks < 7.5) {
            return "Good";
        } else if (Marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }
    
     @Override
    public String toString() {
        return "ID: " + Id + ", Name: " + name + ", Marks: " + Marks + ", Rank: " + getRank();
    }
}