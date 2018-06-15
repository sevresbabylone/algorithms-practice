// A connectivity table displays all vertices that can be reached from any particular vertex
//   Vertex: All the nodes that it connects to
//        A: C
//        B: ACE
//        C:
//        D: EC
//        E: C

public class ConnectivityTableApp {
    public static void main(String[] args) {
        DirectedGraph ctGraph = new DirectedGraph();
        ctGraph.addVertex('a');
        ctGraph.addVertex('b');
        ctGraph.addVertex('c');
        ctGraph.addVertex('d');
        ctGraph.addVertex('e');
        // a
        ctGraph.addEdge(0, 2);
        // b
        ctGraph.addEdge(1, 0);
        ctGraph.addEdge(1, 4);
        // d
        ctGraph.addEdge(3, 4);
        // e
        ctGraph.addEdge(4, 2);
        ctGraph.displayConnectivityTable();
    }
}
