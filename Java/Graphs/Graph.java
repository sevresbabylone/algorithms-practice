public class Graph {
    public final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int nVerts;

    public Graph() {
        vertexList = new vertexList[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        // set adjacency matrix to 0
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    public void addVertex(char label) {
        vertexList[nVerts++]
    }
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].label);
    }
}

