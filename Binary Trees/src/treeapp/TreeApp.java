package treeapp;

import node.Node;
import tree.Tree;

public class TreeApp {
    public static void main(String[] args) {
        Tree treeA = new Tree();
        treeA.insert(50, 3.3);
        treeA.insert(25, 4.4);
        treeA.insert(75, 5.5);
        treeA.insert(60, 5.5);
        treeA.insert(80, 5.5);
        treeA.insert(78, 5.5);
        treeA.insert(79, 5.5);


        treeA.delete(75);
        Node found = treeA.find(treeA.getRoot(), 75);
        if (found != null) {
            found.displayNode();
        }
        else {
            System.out.println("Node cannot be found");
        }
    }
}
