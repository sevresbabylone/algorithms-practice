package queue;

public class Queue {
  private int maxSize;
  private long[] queueArray;
  private int front;
  private int rear;

  public Queue(int s) {
    maxSize = s + 1;
    queueArray = new long[maxSize];
    front = 0;
    rear = -1;
  }
  public void insert(long value) {
    // case: if rear is at top of the queue
    // case: if rear is in the bottom or middle of queue
      if(rear == maxSize) {
          rear = -1;
      }
    queueArray[++rear] = value;
  }
  public long remove() {
      long temp = queueArray[front++];
      if(front == maxSize) {
          front = 0;
      }
      return temp;
  }
  public boolean isFull() {
      return (rear == front + maxSize - 2 || front == rear + 2);
  }
  public boolean isEmpty() {
      return ( rear == front - 1 || rear == front + maxSize - 1 );
  }
  public int size() {
      int noOfElements;
      if (front <= rear) {
          noOfElements = rear - front + 1;
      }
      else {
          noOfElements = rear  + 1  + maxSize - front;
      }
      return noOfElements;
  }
  public long peek() {
      return queueArray[front];
  }
}
