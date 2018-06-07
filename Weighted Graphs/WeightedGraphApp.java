// Adjacency Matrix for wgGraph (undirected)

//           |Abbeville|Bordeaux|Cannes|Dijon|Evry|Fontan
// Abbeville |        0|       6|     0|    4|   0|     0
// Bordeaux  |        6|       0|    10|    7|   7|     0
// Cannes    |        0|      10|     0|    8|   5|     6
// Dijon     |        4|       7|     8|    0|  12|     0
// Evry      |        0|       7|     5|   12|   0|     7
// Fontan    |        0|       0|     6|    0|   7|     0


public class WeightedGraphApp {
    public static void main(String[] args) {
        WeightedGraph wgGraph = new WeightedGraph();
        wgGraph.displayMinimumSpanningTree();
        wgGraph.addVertex("Abbeville");
        wgGraph.addVertex("Bordeaux");
        wgGraph.addVertex("Cannes");
        wgGraph.addVertex("Dijon");
        wgGraph.addVertex("Evry");
        wgGraph.addVertex("Fontan");

        // Expected result -> Abbeville-Dijon, Abbeville-Bordeaux, Bordeaux-Evry, Evry-Cannes, Cannes-Fontan
    }
}
