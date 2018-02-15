package tree;

import node.Node;

public class Tree {
    private Node root;

    public Node find(int key) { // efficiency O(logN)
        Node current = root;
        while (current.iData != key && current != null) {
            if (key >= current.iData) {
                current = current.leftChild;
            }
            else {
                current = current.rightChild;
            }
        }
        return current;
    }
    public void insert(int iData, double fData) {

    }
    public void delete(int key) {

    }
}
