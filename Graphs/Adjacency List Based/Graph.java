import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private Vertex[] vertexList;
    private Queue<Integer> indexQueue;

    private int noOfVerts;
    public Graph(int maxVerts) {
        noOfVerts = 0;
        vertexList = new Vertex[maxVerts];
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
        dfsUtil(0);
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
    }
    public void dfsUtil(int v) {
        vertexList[v].visited = true;
        displayVertex(v);
        Iterator<Integer> dfsIterator = adjacencyList[v].iterator();
        while (dfsIterator.hasNext())
        {
            int n = dfsIterator.next();
            if (!vertexList[n].visited)
                dfsUtil(n);
        }
    }
    public void bfs() {
        indexQueue.add(0);
        while(!indexQueue.isEmpty()) {
            int currentVertex = indexQueue.poll();
            displayVertex(currentVertex);
            vertexList[currentVertex].visited = true;
            Iterator<Integer> bfsIterator = adjacencyList[currentVertex].iterator();
            while (bfsIterator.hasNext()) {
                int n = bfsIterator.next();
                if (!vertexList[n].visited) {
                   indexQueue.add(n);
                }
            }
        }
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
    }
    public void mst() {
        indexQueue.add(0);
        while(!indexQueue.isEmpty()) {
            int currentVertex = indexQueue.poll();
            vertexList[currentVertex].visited = true;
            Iterator<Integer> bfsIterator = adjacencyList[currentVertex].iterator();
            while (bfsIterator.hasNext()) {
                int n = bfsIterator.next();
                if (!vertexList[n].visited) {
                    displayVertex(currentVertex);
                    displayVertex(n);
                    System.out.print(" ");
                    indexQueue.add(n);
                }
            }
        }
        // reset all flags
        for (int j = 0; j < noOfVerts; j++) {
            vertexList[j].visited = false;
        }
    }
}
