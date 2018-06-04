// Adjacency Matrix of gtGraph
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

public class GraphTraversalApp {
        public static void main(String[] args) {
            Graph gtGraph = new Graph();
            gtGraph.addVertex('a');
            gtGraph.addVertex('b');
            gtGraph.addVertex('c');
            gtGraph.addVertex('d');
            gtGraph.addVertex('e');
            gtGraph.addVertex('f');
            gtGraph.addVertex('g');
            gtGraph.addVertex('h');
            gtGraph.addVertex('i');

            // a
            gtGraph.addEdge(0, 1);
            gtGraph.addEdge(0, 2);
            gtGraph.addEdge(0, 3);
            gtGraph.addEdge(0, 4);
            // b
            gtGraph.addEdge(1, 0);
            gtGraph.addEdge(1, 5);
            // c
            gtGraph.addEdge(2, 0);
            // d
            gtGraph.addEdge(3, 0);
            gtGraph.addEdge(3, 6);
            // e
            gtGraph.addEdge(4, 0);
            // f
            gtGraph.addEdge(5, 1);
            gtGraph.addEdge(5, 7);
            // g
            gtGraph.addEdge(6, 3);
            gtGraph.addEdge(6, 8);
            // h
            gtGraph.addEdge(7, 5);
            // i
            gtGraph.addEdge(8, 6);

            System.out.print("Depth-first Search order: ");
            gtGraph.dfs();
            // Expected output => abfhcdgie
            System.out.print("Breadth-first Search order: ");
            gtGraph.bfs();
            // Expected output => abcdefghi
            gtGraph.mst();
            // Expected output => ab bf fh ac ad dg gi ae
            System.out.println();
            gtGraph.mstbf();
            // Expected output =>  ab ac ad ae bf fh dg gi
        }
}

