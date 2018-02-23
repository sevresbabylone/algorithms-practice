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
    public Node minimum() {
        Node current;
        current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }
    public Node maximum() {
        Node current;
        current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
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
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        // search for node
        while (current.getiData() != key && current != null) {
            parent = current;
            if (key < current.getiData()) {
                isLeftChild = true;
                current = current.getLeftChild();
            }
            else {
                isLeftChild = false;
                current = current.getRightChild();
            }
        }
        // node not found in tree
        if (current == null) {
            return false;
        }
        // CASE 1: Node has no children
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            // Only one node in tree
            if (current == root) {
                root = null;
            }
            else if (isLeftChild) {
              parent.setLeftChild(null);
            }
            else {
                parent.setRightChild(null);
            }
        }
        return true;
    }
}
