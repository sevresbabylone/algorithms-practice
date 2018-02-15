package treeapp;

import node.Node;
import tree.Tree;

public class TreeApp {
    public static void main(String[] args) {
        Tree treeA = new Tree();
        treeA.insert(12, 3.3);
        treeA.insert(13, 4.4);
        treeA.insert(14, 5.5);
        Node found = treeA.find(treeA.root, 13);
        if (found != null) {
            System.out.println("Found the node with key 13");
        }
        else {
            System.out.println("Not found");
        }
    }
}
