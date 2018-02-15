package node;

public class Node {
    private int iData;
    private double fData;
    private Node leftChild;
    private Node rightChild;

    public void displayNode() {
        System.out.println("Node: " + iData + " " + fData);
    }
}
