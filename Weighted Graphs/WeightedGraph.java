import java.util.PriorityQueue;

public class WeightedGraph {
    private final int MAX_VERTS = 20;
    private int noOfVerts;
    private Vertex vertexList[];

    public WeightedGraph () {
        vertexList = new Vertex[MAX_VERTS];
        noOfVerts = 0;
    }
    public void addVertex(String label) {
        vertexList[noOfVerts++] = new Vertex(label);
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].label);
    }
    public void displayMinimumSpanningTree(){

    }
}
