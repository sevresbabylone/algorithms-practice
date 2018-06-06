// Adjacency List of gtGraph (Non-directed)
// Vertex : List of adjacent vertexes

// A : B -> C -> D -> E
// B : F
// C :
// D : G
// E :
// F : H
// G : I
// H :
// I :

public class GraphTraversalApp {
    public static void main(String[] args) {
        Graph gtGraph = new Graph(9);
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
        gtGraph.addEdge(1, 5);
        // d
        gtGraph.addEdge(3, 6);
        // f
        gtGraph.addEdge(5, 7);
        // g
        gtGraph.addEdge(6, 8);

        gtGraph.displayAdjacencyList();
        // Expected output
        // A : B -> C -> D -> E
        // B : A -> F
        // C : A
        // D : A -> G
        // E : A
        // F : B -> H
        // G : D -> I
        // H : F
        // I : G

        System.out.print("Depth-first Search order: ");
        gtGraph.dfs();
        // Expected output => abfhcdgie
        System.out.println();
        System.out.print("Breadth-first Search order: ");
        gtGraph.bfs();
        // Expected output => abcdefghi
        System.out.println();
        System.out.print("Breadth-first Search Minimum Spanning Tree: ");
        gtGraph.mst();
        // Expected output =>  ab ac ad ae bf fh dg gi

    }
}
