package com.rizki.uas;

import java.util.Stack;

/**
 *
 * @author Muhammad Rizki Syafapri <12050110483>
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node find(int key) {
        Node current = getRoot();
        while (current.getId() != key) {
            if (key < current.getId()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, String data) {
        Node newNode = new Node();
        newNode.setId(id);
        newNode.setData(data);
        if (getRoot() == null) {
            this.setRoot(newNode);
        } else {
            Node current = getRoot();
            Node parent;
            while (true) {
                parent = current;
                if (id < current.getId()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else if (id > current.getId()) {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                } else {
                    System.out.println("-- Duplicate Key --");
                    return;
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = getRoot();
        Node parent = getRoot();
        boolean isLeftChild = true;
        while (current.getId() != key) {
            parent = current;
            if (key < current.getId()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == getRoot()) {
                this.setRoot(null);
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getRightChild() == null) {
            if (current == getRoot()) {
                this.setRoot(current.getLeftChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == getRoot()) {
                this.setRoot(current.getRightChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == getRoot()) {
                this.setRoot(successor);
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != delNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("Preorder traversal: ");
                preOrder(getRoot());
                break;
            case 2:
                System.out.print("Inorder traversal: ");
                inOrder(getRoot());
                break;
            case 3:
                System.out.print("Postorder traversal: ");
                postOrder(getRoot());
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getId() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getId() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getId() + " ");
        }
    }

    public int findMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int res = node.getId();
        int lres = findMax(node.getLeftChild());
        int rres = findMax(node.getRightChild());

        if (lres > res) {
            res = lres;
        }
        if (rres > res) {
            res = rres;
        }
        return res;
    }

    public int findMin(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int res = node.getId();
        int lres = findMin(node.getLeftChild());
        int rres = findMin(node.getRightChild());

        if (lres < res) {
            res = lres;
        }
        if (rres < res) {
            res = rres;
        }
        return res;
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(getRoot());
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getId());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("......................................................");
    }
}
