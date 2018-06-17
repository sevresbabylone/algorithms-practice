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
        System.out.println(pathArray[destinationVertex]);
            System.out.println("Expected cost: $" + distanceArray[destinationVertex]);
        // display minimum cost table
        for (int k = 0; k < noOfVerts; k++) {
            if (distanceArray[k] == INFINITY || distanceArray[k] == 0) continue;
            System.out.println( vertexList[k].label + ":$" + distanceArray[k]);
        }
        System.out.println();

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
        return minimumIndex;
    }
    // Method that implements Floyd's algorithm for a graph
    // represented using adjacency matrix representation
    // and displays All-Pairs Shortest Path table

    public void displayAllPairsShortestPath() {
        int AllPairsShortestPath[][] = new int[noOfVerts][noOfVerts];
        for (int k = 0; k < noOfVerts; k++) {
            for (int l = 0; l < noOfVerts; l++) {
                if (k == l) {
                    AllPairsShortestPath[k][l] = 0;
                    continue;
                }
                AllPairsShortestPath[k][l] = adjacencyMatrix[k][l];
            }
        }
        // An 'L' shape indicates a path from B to A, from A to C,
        // therefore, there is an alternative path from  B to C
        // this direct path is compared to the alternative path and replaced if greater than alternative path
        // [i][j] > [i][k] + [k][j]
        //   A B C
        // A     X
        // B X X X

        // First loop k is a marker to the top of the L (i.e. row A in this case)
        // Second loop i is a marker to the bottom of the L (i.e. row B )
        // Third loop j loops through cells of a column, elongating the L
        // When the whole board is looped through with all possibilities of 'L's,
        // we will be left with the all pairs shortest path table

        for (int k = 0; k < noOfVerts; k++) {
            for (int i = 0; i < noOfVerts; i++) {
                for (int j = 0; j < noOfVerts; j++) {
                    if (AllPairsShortestPath[i][j] > AllPairsShortestPath[i][k] + AllPairsShortestPath[k][j]) {
                        AllPairsShortestPath[i][j] = AllPairsShortestPath[i][k] + AllPairsShortestPath[k][j];
                    }
                }
            }
        }
        System.out.println();
        for (int j = 0; j < noOfVerts; j++) {
            for (int k = 0; k < noOfVerts; k++) {
                if (AllPairsShortestPath[j][k] == INFINITY) {
                    System.out.print("-- ");
                    continue;
                }
                System.out.print(AllPairsShortestPath[j][k] + " ");
            }
            System.out.println();
        }


    }
}
