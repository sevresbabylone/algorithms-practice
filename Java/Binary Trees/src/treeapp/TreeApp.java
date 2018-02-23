package treeapp;

import node.Node;
import tree.Tree;

public class TreeApp {
    public static void main(String[] args) {
        Tree treeA = new Tree();
        treeA.insert(10, 3.3);
        treeA.insert(5, 4.4);
        treeA.insert(3, 5.5);
        treeA.insert(7, 5.5);
//        treeA.insert(2, 5.5);
//        treeA.insert(10, 5.5);
//        treeA.insert(123, 5.5);
//        treeA.insert(133, 5.5);
//        treeA.insert(140, 5.5);

        Node found = treeA.find(treeA.getRoot(), 13);
        if (found != null) {
            found.displayNode();
        }

        Node maximum = treeA.maximum();
        maximum.displayNode();
        treeA.delete(3);
        Node minimum = treeA.minimum();
        minimum.displayNode();
    }
}
