

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

public class BFSGraph<T> {

    private int numberofVertices;
    private MyLinkedList<Vertex<T>>[] adjacencyList;
    private MyQueue<Vertex<T>> queue;



    public BFSGraph(int vertices){
        this.numberofVertices = vertices;
        adjacencyList = new MyLinkedList[numberofVertices];

        for (int index=0; index<numberofVertices; index++){
            adjacencyList[index] = new MyLinkedList<>();
        }
        queue = new MyQueue<>();
    }

    public void insertEdge(Vertex<T> vertex, Vertex<T> neighbor){
        /* adding an edge to the adjacency list (edges are bidirectional in this example) */
        adjacencyList[vertex.getIndex()].add(neighbor);

    }

    public void BFS(Vertex<T> root)
    {
        /* initialize boolean array for holding the data */
        boolean[] vertexVisited = new boolean[numberofVertices];
        Vertex<T> visiting;
        vertexVisited[root.getIndex()] = true;

        /* root node is added to the top of the queue */
        queue.enqueue(root);

        while (!queue.isEmpty()){
            /*remove top element of the queue*/
            root = queue.dequeue();
            System.out.print(root + " ");

            /* iterate through the linked list and push all neighbors into queue */
            for(int i =0; i<adjacencyList[root.getIndex()].getSize();i++){
                visiting= adjacencyList[root.getIndex()].get(i);
                /* only insert nodes into queue if they have not been explored already */
                if(!vertexVisited[visiting.getIndex()]){
                    vertexVisited[visiting.getIndex()] = true;
                    queue.enqueue(visiting);
                }
            }
        }

    }

    public static void main(String[] args) {

        BFSGraph graph = new BFSGraph(6);
        graph.insertEdge(new Vertex<>("Kuantan",0), new Vertex<>("Perlis", 1));
        graph.insertEdge(new Vertex<>("Kuantan",0), new Vertex<>("Perak", 3));
        graph.insertEdge(new Vertex<>("Kuantan",0), new Vertex<>("Korea", 4));
        graph.insertEdge(new Vertex<>("Korea", 4), new Vertex<>("Japan", 5));
        graph.insertEdge(new Vertex<>("Perak", 3),  new Vertex<>("Japan", 5));
        graph.insertEdge(new Vertex<>("Perlis", 1), new Vertex<>("Kedah", 2));
        graph.insertEdge(new Vertex<>("Perlis", 1), new Vertex<>("Kuantan",0));
        graph.insertEdge(new Vertex<>("Kedah", 2),  new Vertex<>("Perlis", 1));
        graph.insertEdge(new Vertex<>("Korea", 4), new Vertex<>("Perlis", 1));
        graph.insertEdge(new Vertex<>("Perak", 3), new Vertex<>("Perlis", 1));
        graph.insertEdge( new Vertex<>("Japan", 5), new Vertex<>("Korea", 4));
        graph.insertEdge( new Vertex<>("Japan", 5), new Vertex<>("Perak", 3));
        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(new Vertex<>("Kuantan",0));
    }



}
