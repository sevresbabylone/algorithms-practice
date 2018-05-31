import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph {
    public final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int noOfVerts;
    private Stack<Integer> indexStack;
    private Queue<Integer> indexQueue;

    public DirectedGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        noOfVerts = 0;
        indexStack = new Stack<Integer>();
        indexQueue = new LinkedList<Integer>();
        // set initial adjacency matrix to 0
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    public void addVertex(char label) {
        vertexList[noOfVerts++] = new Vertex(label);
    }
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].label);
    }
    // Step 1: Find a vertex that has no successors
    // Step 2: Delete this vertex from the graph, and insert its label at the beginning of a list.

    // Repeat Steps 1 and 2 until all the vertices are gone.
    // At this point, the list shows the vertices arranged in topological order.
    // Note: Does not handle graphs with cycles, only directed acyclic graphs
    public void topologicalSort() {
        Stack<Integer> topologicalStack = new Stack<Integer>();

    }
    public void topologicalSortUtil() {

    }
}