import java.util.PriorityQueue;

public class WeightedGraph {
    private final int MAX_VERTS = 20;
    public final int INFINITY = 100000;
    private int noOfVerts;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];

    public WeightedGraph () {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        noOfVerts = 0;
        for (int j = 0; j < MAX_VERTS) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjacencyMatrix[j][k] = INFINITY;
            }
        }
    }
    public void addVertex(String label) {
        vertexList[noOfVerts++] = new Vertex(label);
    }
    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
        adjacencyMatrix[end][start] = weight;
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].label);
    }

    // Minimum Spanning Tree for Weighted Graph (non-directed, connected)
    // 1. Find all the edges from the newest vertex to the other vertices that aren't in the tree. Put these edges in the priority queue.
    // 2. Pick the edge with the lowest weight, then add this edge and its destination vertex to the tree.
    // 3 Remove paths to vertexes already in the tree
    // Error Handling for non-connected graphs
    public void displayMinimumSpanningTree(){
        EdgePriorityQueue edgeQueue = new EdgePriorityQueue();
        int currentVertex = 0;
        int noOfVertsInTree = 0;
        while (noOfVertsInTree < noOfVerts) {
            // put current vertex in tree
            vertexList[currentVertex].isInTree = true;
            noOfVertsInTree++;
        }
        for (int j = 0; j < noOfVerts; j++) {
            if (vertexList[j].isInTree) continue;
            int weight = adjacencyMatrix[currentVertex][j];
            if (weight == INFINITY) continue; // skip if no edge
            edgeQueue.insert(new Edge(currentVertex, j, weight));

        }
        // add all edges adjacent to currentVertex into edgeQueue

    }
}
