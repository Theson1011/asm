/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.node;

/**
 *
 * @author ADMIN
 */
class Node {
    Student data;
    Node next;

    public Node(Student data) {
        this.data = data;
        this.next = null;
    }
}