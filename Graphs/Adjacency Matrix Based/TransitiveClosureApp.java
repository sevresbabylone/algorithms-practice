// Adjacency Matrix of tcGraph (directed, non-weighted)
//    A B C D E
//A   0 0 1 0 0
//B   1 0 0 0 1
//C   0 0 0 0 0
//D   0 0 0 0 1
//E   0 0 1 0 0

public class TransitiveClosureApp {
    public static void main(String[] args) {
        DirectedGraph tcGraph = new DirectedGraph();
        tcGraph.addVertex('a');
        tcGraph.addVertex('b');
        tcGraph.addVertex('c');
        tcGraph.addVertex('d');
        tcGraph.addVertex('e');
        // a
        tcGraph.addEdge(0, 2);
        // b
        tcGraph.addEdge(1, 0);
        tcGraph.addEdge(1, 4);
        // d
        tcGraph.addEdge(3, 4);
        // e
        tcGraph.addEdge(4, 2);
        tcGraph.displayTransitiveClosure();
        // Expected output ->
        //    A B C D E
        //A   0 0 1 0 0
        //B   1 0 1 0 1
        //C   0 0 0 0 0
        //D   0 0 1 0 1
        //E   0 0 1 0 0
    }
}
