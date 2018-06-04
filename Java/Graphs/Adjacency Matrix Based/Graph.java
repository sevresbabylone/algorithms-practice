import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    public final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int noOfVerts;
    private Stack<Integer> indexStack;
    private Queue<Integer> indexQueue;

    public Graph() {
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
        adjacencyMatrix[end][start] = 1;
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].label);
    }
    // depth-first search (iterative)
    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        indexStack.push(0);
        while (!indexStack.isEmpty()) { // until stack empty
            // get an unvisited vertex adjacent to stack top
            int v = getUnvisitedAdjacentVertex(indexStack.peek());
            if (v == -1) { // if no such vertex in indexStack, pop top off
                indexStack.pop();
            }
            else {
                vertexList[v].visited = true;
                displayVertex(v);
                indexStack.push(v);
            }
        }
        System.out.println();
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
    }

    public int getUnvisitedAdjacentVertex(int v) {
        for (int j = 0; j < noOfVerts; j++) {
            if (adjacencyMatrix[v][j] == 1 && vertexList[j].visited == false) {
                return j;
            }
        }
        return - 1;
    }
    // Stay as close as possible to the starting point
    // visit next unvisited vertex that is adjacent to the current vertex, mark it, and insert it into the queue
    // else remove a vertex from the queue (if possible) and make it the current vertex
    // if queue is empty, end

    public void bfs() {
        int currentVertex = 0;
        int adjacentVertex;
        indexQueue.add(currentVertex);
        vertexList[0].visited = true;
        displayVertex(0);
        while (!indexQueue.isEmpty()) {
            currentVertex = indexQueue.remove();
            while ((adjacentVertex = getUnvisitedAdjacentVertex(currentVertex)) != -1) {
                vertexList[adjacentVertex].visited = true;
                displayVertex(adjacentVertex);
                indexQueue.add(adjacentVertex);
            }
        }
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
        System.out.println();
    }
    // minimum spanning tree (depth-first)
    public void mst() {
        vertexList[0].visited = true;
        indexStack.push(0);
        while (!indexStack.isEmpty()) {
            int currentVertex = indexStack.peek();
            int v = getUnvisitedAdjacentVertex(currentVertex);
            if (v == -1) {
                indexStack.pop();
            }
            else {
                vertexList[v].visited = true;
                indexStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
    }
    // minimum spanning tree (breadth-first)
    public void mstbf() {
        int currentVertex = 0;
        int adjacentVertex;
        vertexList[currentVertex].visited = true;
        indexQueue.add(currentVertex);
        while(!indexQueue.isEmpty()) {
            currentVertex = indexQueue.remove();
            while ((adjacentVertex = getUnvisitedAdjacentVertex(currentVertex)) != -1) {
                vertexList[adjacentVertex].visited = true;
                displayVertex(currentVertex);
                displayVertex(adjacentVertex);
                System.out.print(" ");
                indexQueue.add(adjacentVertex);
            }
        }
    }

}