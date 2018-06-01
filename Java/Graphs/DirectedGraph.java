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
    // Step 1: Find a vertex that has no successors
    // Step 2: Remove this vertex from the graph, and insert its label at the beginning of a list.

    // Repeat Steps 1 and 2 until all the vertices are gone.
    // At this point, the list shows the vertices arranged in topological order.
    // Throw error if not an directed acyclic graph (i.e. no cycles)
    public void topologicalSortRecur() {
        boolean removed[] = new boolean[noOfVerts];

        Stack<Integer> topologicalStack = new Stack<Integer>();

        // mark all vertices as not removed, not processed
        for (int i = 0; i < noOfVerts; i++) {
            removed[i] = false;
        }
        for (int j = 0; j < noOfVerts; j++) {
            if (vertexList[j].visited == false) {
                topologicalSortUtil(j, removed, topologicalStack);
            }
        }

        System.out.print("Topologically sorted order: ");
        while(!topologicalStack.isEmpty()) {
         System.out.print(topologicalStack.pop());
        }
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
        System.out.println();
    }

    public void topologicalSortUtil(int currentVertex, boolean[] removed, Stack topologicalStack) {
        int adjacentVertex;
        vertexList[currentVertex].visited = true;
        // Recur for each adjacent unvisited vertex
        // Push current vertex to stack that stores result
        while ((adjacentVertex = getUnvisitedAdjacentVertex(currentVertex)) != -1) {
            if (removed[adjacentVertex] == true) {
                System.out.println("ERROR: Graph has cycles");
                break;
            }
            topologicalSortUtil(adjacentVertex, removed, topologicalStack);
        }
        topologicalStack.push(vertexList[currentVertex].label);
        removed[currentVertex] = true;
    }
    public int getUnvisitedAdjacentVertex(int currentVertex) {
        for (int i = 0; i < noOfVerts; i++) {
            if (adjacencyMatrix[currentVertex][i] == 1 && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
}

