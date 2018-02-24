package treeapp;

import node.Node;
import tree.Tree;

public class TreeApp {
    public static void main(String[] args) {
        Tree treeA = new Tree();
        treeA.insert(80, 3.3);
        treeA.insert(52, 4.4);
        treeA.insert(48, 5.5);
        treeA.insert(71, 5.5);
        treeA.insert(63, 5.5);
        treeA.insert(67, 5.5);
//        treeA.insert(123, 5.5);
//        treeA.insert(133, 5.5);
//        treeA.insert(140, 5.5);


        treeA.delete(71);
        Node found = treeA.find(treeA.getRoot(), 71);
        if (found != null) {
            found.displayNode();
        }
        else {
            System.out.println("Node cannot be found");
        }

    }
}
