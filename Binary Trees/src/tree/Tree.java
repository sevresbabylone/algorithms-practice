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
        // CASE 2: Node has 1 child
        // // -> Node is left child of parent, it has 1 child on the left
        // // -> Node is left child of parent, it has 1 child on the right
        else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            }
            else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            }
            else {
                parent.setRightChild(current.getLeftChild());
            }
        }
        // // -> Node is right child of parent, it has 1 child on the left
        // // -> Node is right child of parent, it has 1 child on the right
        else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            }
            else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            }
            else {
                parent.setRightChild(current.getRightChild());
            }
        }
        // CASE 3: Node has 2 children
        else {
            // Find the smallest of the set of nodes that are larger than the original node

            // Parent's rightChild now points to successor
            // Successor takes deleteNode's leftChild and rightChild
            // -> Successor has a right child
            // Successor's parent's leftChild now points to successorRightChild
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            }
            else if (isLeftChild) {
                parent.setLeftChild(successor);
            }
            else {
                parent.setRightChild(successor);
            }
            // -> Successor is left descendant of rightChild of deleteNode
            // successor's parent's leftChild = rightChild of successor
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }
    // TODO : Recursive solution for delete
    public boolean deleteRecursive(int key) {
        // base case
        return true;
    }
    public Node getSuccessor(Node deleteNode) {
        Node successorParent = deleteNode;
        Node successor = deleteNode.getRightChild();
        while (successor.getLeftChild() != null) {
            successorParent = successor;
            successor = successor.getLeftChild();
        }
        // if successor is not the rightChild (i.e. immediate child) of deleteNode,
        // // then the descendants of successor (only rightChildren) become leftChild of successorParent
        if (successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            // successor takes over deleteNodes rightChildren
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }

}
