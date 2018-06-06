import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private Vertex[] vertexList;
    private Stack<Integer> indexStack;
    private Queue<Integer> indexQueue;

    private int noOfVerts;
    public Graph(int maxVerts) {
        noOfVerts = 0;
        vertexList = new Vertex[maxVerts];
        indexStack = new Stack<Integer>();
        indexQueue = new LinkedList<Integer>();
        adjacencyList = new LinkedList[maxVerts];
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 0; i < maxVerts ; i++){
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }
    public void addVertex(char label) {
        vertexList[noOfVerts++] = new Vertex(label);
    }
    public void addEdge(int source, int destination) {
        adjacencyList[source].addLast(destination);
        adjacencyList[destination].addLast(source);
    }
    public void displayAdjacencyList() {
        for(int i = 0; i < noOfVerts; i++) {
            Iterator<Integer> vertexIterator = adjacencyList[i].iterator();
            System.out.print(vertexList[i].label + " : ");
            while(vertexIterator.hasNext()) {
                System.out.print(vertexList[vertexIterator.next()].label);
                if (vertexIterator.hasNext()) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].label);
    }
    public void dfs() {

    }
    public void bfs() {
    }
    public void mst() {

    }
}
