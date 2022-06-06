

//1. Take the data for the graph's adjacency matrix or adjacency list.
//2. Create a queue and fill it with items.
//3. Activate the root node (meaning that get the root node at the beginning of the queue).
//4. Dequeue the queue's head (or initial element), then enqueue all of the queue's nearby
//  nodes from left to right. Simply dequeue the head and resume the operation if a node
//  has no nearby nodes that need to be investigated.
// (Note: If a neighbor emerges that has previously been investigated or is in the queue,
//  don't enqueue it; instead, skip it.)
//5. Continue in this manner until the queue is empty.

//Queue //for unweighted graphs

public class BFSGraph {

    private int numberofVertices;
    private MyLinkedList<Integer>[] adjacencyList;
    private MyQueue<Integer> queue;



    public BFSGraph(int vertices){
        this.numberofVertices = vertices;
        adjacencyList = new MyLinkedList[numberofVertices];

        for (int index=0; index<numberofVertices; index++){
            adjacencyList[index] = new MyLinkedList<>();
        }
        queue = new MyQueue<>();
    }

    public void insertEdge(int vertex, int neighbor){
        /* adding an edge to the adjacency list (edges are bidirectional in this example) */
        adjacencyList[vertex].add(neighbor);

    }

    public void BFS(int root)
    {
        /* initialize boolean array for holding the data */
        boolean[] vertexVisited = new boolean[numberofVertices];
        int visiting =0;
        vertexVisited[root] = true;

        /* root node is added to the top of the queue */
        queue.enqueue(root);

        while (!queue.isEmpty()){
            /*remove top element of the queue*/
            root = queue.dequeue();
            System.out.print(root + " ");

            /* iterate through the linked list and push all neighbors into queue */
            for(int i =0; i<adjacencyList[root].getSize();i++){
                visiting= adjacencyList[root].get(i);
                /* only insert nodes into queue if they have not been explored already */
                if(!vertexVisited[visiting]){
                    vertexVisited[visiting] = true;
                    queue.enqueue(visiting);
                }
            }
        }

    }

    public static void main(String[] args) {

        BFSGraph graph = new BFSGraph(6);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(0, 4);
        graph.insertEdge(4, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 0);
        graph.insertEdge(2, 1);
        graph.insertEdge(4, 1);
        graph.insertEdge(3, 1);
        graph.insertEdge(5, 4);
        graph.insertEdge(5, 3);
        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(0);
    }



}
