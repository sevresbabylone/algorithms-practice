import java.util.LinkedList;
import java.util.Stack;

public class DirectedGraph {
    public class GraphCycleException extends Exception {

    }

    public final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int noOfVerts;

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
    // Topological Search
    // Step 1: Find a vertex that has no successors
    // Step 2: Remove this vertex from the graph, and insert its label at the beginning of a list.

    // Repeat Steps 1 and 2 until all the vertices are gone.
    // At this point, the list shows the vertices arranged in topological order.
    // Throw error if not an directed acyclic graph (i.e. no cycles)

    public void topologicalSortRecur() {
        boolean removed[] = new boolean[noOfVerts];

        Stack<Integer> topologicalStack = new Stack<Integer>();

        // mark all vertices as not removed
        for (int i = 0; i < noOfVerts; i++) {
            removed[i] = false;
        }
        try {
            for (int j = 0; j < noOfVerts; j++) {
                if (removed[j] == false) {
                    topologicalSortUtil(j, removed, topologicalStack);
                }
            }
        } catch (GraphCycleException ex) {
            System.out.println("ERROR: Graph has cycles");
            return;
        }

        System.out.print("Topologically sorted order: ");
        while(!topologicalStack.isEmpty()) {
         System.out.print(topologicalStack.pop());
        }
    }

    public void topologicalSortUtil(int currentVertex, boolean[] removed, Stack topologicalStack) throws GraphCycleException {
        int adjacentVertex;
        vertexList[currentVertex].visited = true;
        // Recur for each adjacent unvisited vertex
        // Push current vertex to stack that stores result

        while ((adjacentVertex = getUnvisitedAdjacentVertex(currentVertex, removed)) != -1) {
            topologicalSortUtil(adjacentVertex, removed, topologicalStack);
        }
        topologicalStack.push(vertexList[currentVertex].label);
        removed[currentVertex] = true;
    }
    public int getUnvisitedAdjacentVertex(int currentVertex,  boolean[] removed) throws GraphCycleException {
        for (int i = 0; i < noOfVerts; i++) {
            if (adjacencyMatrix[currentVertex][i] == 1 && vertexList[i].visited && removed[i] == false) {
                throw new GraphCycleException();
            }
            if (adjacencyMatrix[currentVertex][i] == 1 && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
}

