package node;

public class Node {
    private int iData;
    private double fData;
    private Node leftChild;
    private Node rightChild;

    public Node (int i, double f) {
        iData = i;
        fData = f;
        leftChild = rightChild = null;
    }
    public void displayNode() {
        System.out.println("Node: " + iData + " " + fData);
    }
    public int getiData() {
        return iData;
    }
    public Node getLeftChild() {
        return leftChild;
    }
    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public double getfData() {
        return fData;
    }
}
