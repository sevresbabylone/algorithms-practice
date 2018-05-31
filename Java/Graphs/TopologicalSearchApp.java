// Adjacency Matrix of tsGraph
//    A B C D E F G H
//A   0 0 0 1 1 0 0 0
//B   0 0 0 0 1 0 0 0
//C   0 0 0 0 0 1 0 0
//D   0 0 0 0 0 0 1 0
//E   0 0 0 0 0 0 1 0
//F   0 0 0 0 0 0 0 1
//G   0 0 0 0 0 0 0 1
//H   0 0 0 0 0 0 0 0

public class TopologicalSearchApp {
    public static void main(String[] args) {
        DirectedGraph tsGraph = new DirectedGraph();
        tsGraph.addVertex('a');
        tsGraph.addVertex('b');
        tsGraph.addVertex('c');
        tsGraph.addVertex('d');
        tsGraph.addVertex('e');
        tsGraph.addVertex('f');
        tsGraph.addVertex('g');
        tsGraph.addVertex('h');

        // a
        tsGraph.addEdge(0, 3);
        tsGraph.addEdge(0, 4);
        // b
        tsGraph.addEdge(1, 4);
        // c
        tsGraph.addEdge(2, 5);
        // d
        tsGraph.addEdge(3, 6);
        // e
        tsGraph.addEdge(4, 6);
        // f
        tsGraph.addEdge(5, 7);
        // g
        tsGraph.addEdge(6, 7);
        // h => no successors
    }
}
