package link;

public class Link {
    public Link next;
    public Link previous;
    public int iData;
    public Link (int i) {
        iData = i;
    }
    public void displayLink () {
        System.out.println(iData);
    }
}
