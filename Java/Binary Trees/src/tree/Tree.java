package tree;

import node.Node;

public class Tree {
    public Node root;
    public Tree() {
        root = null;
    }
    public Node find(Node root, int key) { // efficiency O(logN)
        if (root == null || root.iData == key) {
            return root;
        }
        if (root.iData > key) {
            return find(root.leftChild, key);
        }
        else {
            return find(root.rightChild, key);
        }
    }
    public void insert(int iData, double fData) {
        Node newNode = new Node(iData, fData);
        root = insertRec(newNode, root);
    }
    public Node insertRec(Node newNode, Node root) {
        if (root == null) {
            root = newNode;
            return root;
        }
        if (newNode.iData < root.iData) {
            root.leftChild = insertRec(newNode, root.leftChild);
        }
        else {
            root.rightChild = insertRec(newNode, root.rightChild);
        }
        return root;
    }
//    public void delete(int key) {
//
//    }
}
