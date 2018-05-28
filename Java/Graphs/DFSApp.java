// Adjacency Matrix of dfsGraph
//    A B C D E F G H I
//A   0 1 1 1 1 0 0 0 0
//B   1 0 0 0 0 1 0 0 0
//C   1 0 0 0 0 0 0 0 0
//D   1 0 0 0 0 0 1 0 0
//E   1 0 0 0 0 0 0 0 0
//F   0 1 0 0 0 0 0 1 0
//G   0 0 0 1 0 0 0 0 1
//H   0 0 0 0 0 1 0 0 0
//I   0 0 0 0 0 0 1 0 0

public class DFSApp {
    public static void main(String[] args) {
        Graph dfsGraph = new Graph();
        dfsGraph.addVertex('a');
        dfsGraph.addVertex('b');
        dfsGraph.addVertex('c');
        dfsGraph.addVertex('d');
        dfsGraph.addVertex('e');
        dfsGraph.addVertex('f');
        dfsGraph.addVertex('g');
        dfsGraph.addVertex('h');
        dfsGraph.addVertex('i');

        // a
        dfsGraph.addEdge(0, 1);
        dfsGraph.addEdge(0, 2);
        dfsGraph.addEdge(0, 3);
        dfsGraph.addEdge(0, 4);
        // b
        dfsGraph.addEdge(1, 0);
        dfsGraph.addEdge(1, 5);
        // c
        dfsGraph.addEdge(2, 0);
        // d
        dfsGraph.addEdge(3, 0);
        dfsGraph.addEdge(3, 6);
        // e
        dfsGraph.addEdge(4, 0);
        // f
        dfsGraph.addEdge(5, 1);
        dfsGraph.addEdge(5, 7);
        // g
        dfsGraph.addEdge(3, 8);
        dfsGraph.addEdge(6, 8);
        // h
        dfsGraph.addEdge(7, 5);
        // i
        dfsGraph.addEdge(8, 6);

        System.out.print("Depth-first Search order: ");
        dfsGraph.dfs();
        // Expected output => abfhcdgie
    }
}
