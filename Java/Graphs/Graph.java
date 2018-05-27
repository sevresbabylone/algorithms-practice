public class Graph {
    public final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int noOfVerts;
    private Stack indexStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        noOfVerts = 0;
        indexStack = new Stack(20);
        // set adjacency matrix to 0
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
        while (!indexStack.isEmpty()) {
            int v = getUnvisitedAdjacentVertex(indexStack.peek());
            if (v == -1) { // if no such vertex in indexStack
                indexStack.pop();
            }
            else {
                vertexList[v].visited = true;
                displayVertex(v);
                indexStack.push(v);
            }
        }
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
    // depth-first search (recursive)

}

