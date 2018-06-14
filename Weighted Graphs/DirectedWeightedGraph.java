import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedWeightedGraph {
    private final int MAX_VERTS = 20;
    public final int INFINITY = 100000;
    private int noOfVerts;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];

    public DirectedWeightedGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        noOfVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
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
    }
    // Method that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    public void shortestPath(String start, String end) {
        int sourceVertex = getIndexFromLabel(start);
        int destinationVertex = getIndexFromLabel(end);

        Queue<Integer> shortestPathQueue = new LinkedList<Integer>();
        int distanceArray[] = new int[noOfVerts];
        String pathArray[] = new String[noOfVerts];
        for (int i = 0; i < noOfVerts; i++) {
            distanceArray[i] = INFINITY;
        }
        pathArray[sourceVertex] = vertexList[sourceVertex].label;

        // initialise source to 0
        distanceArray[sourceVertex] = 0;
            for (int count = 0; count < noOfVerts-1; count++) {
                int currentVertex = pickMinimum(distanceArray);
//                System.out.print(vertexList[currentVertex].label);
                shortestPathQueue.add(currentVertex);
                vertexList[currentVertex].isInTree = true;
                // update adjacent vertices in distance array
                for (int j = 0; j < noOfVerts; j++) {
                    if (adjacencyMatrix[currentVertex][j] != 0 &&
                            !vertexList[j].isInTree &&
                            distanceArray[currentVertex] + adjacencyMatrix[currentVertex][j] < distanceArray[j]) {
                        distanceArray[j] = distanceArray[currentVertex] + adjacencyMatrix[currentVertex][j];
                        pathArray[j] = pathArray[currentVertex];
                        pathArray[j] += "->" + vertexList[j].label;
                    }
                }
            }

        // reset flags
        for (int i = 0; i < noOfVerts; i++) {
            vertexList[i].isInTree = false;
        }
        if (distanceArray[destinationVertex] == INFINITY) {
           System.out.println("Destination is unreachable from source");
        }
        else {
            System.out.println(pathArray[destinationVertex]);
            System.out.println("Expected cost: $" + distanceArray[destinationVertex]);
        }
    }

    public int getIndexFromLabel(String label) {
        int i = 0;
        while (vertexList[i].label != label) {
            i++;
        }
        return i;
    }
    public int pickMinimum(int[] distanceArray)  {
        if (distanceArray == null || distanceArray.length == 0) return -1;
        // check not in shortestPathQueue
        int minimum = INFINITY;
        int minimumIndex = -1;
        for (int i = 0; i < distanceArray.length; i++)
            if (distanceArray[i] < minimum && !vertexList[i].isInTree) {
                minimumIndex = i;
                minimum = distanceArray[i];
            }
//        if (minimum == INFINITY) {
//            throw new UnreachableException();
//        }
        return minimumIndex;
    }
}
