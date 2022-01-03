package com.rizki.uas;

/**
 *
 * @author Muhammad Rizki Syafapri <12050110483>
 */
public class Node {

    private int id;
    private String data;
    private Node leftChild;
    private Node rightChild;

    public void displayNode() {
        System.out.print("{ " + this.id + ", " + this.data + " }");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
