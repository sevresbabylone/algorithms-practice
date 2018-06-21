# Programming Projects

## Heaps
- Convert the Heap.java class such that it is an ascending heap rather than descending heap. ([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Heaps/AscendingHeap.java))


- Write a toss() method that places a new node in the heap array without attempting to maintain the heap condition ( Each new item can simply be placed at the end of the array.). Write a restoreHeap() method that restores the heap condition throughout the entire heap. Using toss() repeatedly followed by a single restoreHeap() is more efficient than using insert() repeatedly when a large amount of data must be inserted at one time.

- Implement a Priority queue  using a heap instead of an array. Make it a descending queue (largest item is removed).

-  Implementing a priority queue with an ordinary binary search tree rather than a heap. A tree can grow as large as it wants (except for system-memory constraints). Start by modifying the Tree class so it supports priority queues by adding a removeMax() method that removes the largest item. In a heap this is easy, but in a tree it’s slightly harder. How do you find the largest item in a tree? Do you need to worry about both its children when you delete it? Implementing change() is optional. It’s easily handled in a binary search tree by deleting the old item and inserting a new one with a different key. Insertion and removeMax() will operate in O(logN) time.

- Write a tree based implementation of the heap. Make sure you can remove the largest item, insert items, and change an item’s key.

## Graphs
- Modify the mst() method of Graph class to find the minimum spanning tree using breadth-first search, rather than depth-first search. In main(), create a graph with 9 vertices and 12 edges and find its minimum spanning tree ([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Graphs/Adjacency%20Matrix%20Based/Graph.java))

- Modify Graph class to use adjacency lists rather than an adjacency matrix. ([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Graphs/Adjacency%20List%20Based/Graph.java))

- Create a method to display a connectivity table for a directed graph ([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Graphs/Adjacency%20Matrix%20Based/Graph.java))

- Implement Warshall's algorithm to find the transitive closure for a graph. ([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Graphs/Adjacency%20Matrix%20Based/DirectedGraph.java))

- The Knight's Tour is an ancient and famous chess puzzle. The object is to move a knight from one square to another on an otherwise empty chess board until it has visited every square exactly once. Write a program that solves this puzzle using a depth-first-search.

## Weighted Graphs
- Modify the shortest path program to print a table of the minimum costs to get from any vertex to any other vertex.([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Weighted%20Graphs/DirectedWeightedGraph.java))

- Implement Floyd's algorithm. ([Solution](https://github.com/sevresbabylone/data-structures-in-java/blob/master/Weighted%20Graphs/DirectedWeightedGraph.java))

- Implement the traveling salesman problem described in the “Intractable Problems” section in this chapter. In spite of its intractability, it will have no trouble solving the problem for small N, say 10 cities or fewer.

- Write a program that discovers and displays all the Hamiltonian cycles of a weighted, non-directed graph
