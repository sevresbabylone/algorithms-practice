package tree;

import node.Node;

public class Tree {
    private Node root;
    public Tree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public Node find(Node root, int key) {
        if (root == null || root.getiData() == key) {
            return root;
        }
        if (root.getiData() > key) {
            return find(root.getLeftChild(), key);
        }
        else {
            return find(root.getRightChild(), key);
        }
    }
    public void insert(int iData, double fData) {
        Node newNode = new Node(iData, fData);
        root = insertRec(newNode, root);
    }
    private Node insertRec(Node newNode, Node root) {
        if (root == null) {
            root = newNode;
            return root;
        }
        if (newNode.getiData() < root.getiData()) {
            root.setLeftChild(insertRec(newNode, root.getLeftChild()));
        }
        else {
            root.setRightChild(insertRec(newNode, root.getRightChild()));
        }
        return root;
    }
    private void inOrder(Node localRoot) {
        if(localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getiData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }
    public void displayTree() {

    }
    public void delete(int key) {

    }
}
