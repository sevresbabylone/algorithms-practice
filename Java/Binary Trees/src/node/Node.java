package node;

public class Node {
    public int iData;
    public double fData;
    public Node leftChild;
    public Node rightChild;

    public Node (int i, double f) {
        iData = i;
        fData = f;
        leftChild = rightChild = null;
    }
    public void displayNode() {
        System.out.println("Node: " + iData + " " + fData);
    }
}
