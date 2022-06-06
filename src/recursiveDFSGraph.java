package Graph;

//    1.Start by putting any one of the graph's vertices on top of a stack.
//    2.Take the top item of the stack and add it to the visited list.
//    3.Create a list of that vertex's adjacent nodes. Add the ones which
//    aren't in the visited list to the top of the stack.
//    4.Keep repeating steps 2 and 3 until the stack is empty

//Recursive // for weighted graphs



public class recursiveDFSGraph {

    private MyLinkedList<Integer> adjacencyList[];
    private int vertices;

    /**
     * Create a graph
     * @param vertices number of nodes
     */
    public recursiveDFSGraph(int vertices){
       this.vertices = vertices;
       adjacencyList = new MyLinkedList[vertices];
       for(int i =0; i<vertices;++i){
           adjacencyList[i] = new MyLinkedList<>();
       }
    }

    /**
     * Add edge into the graph
     * @param source
     * @param destination
     */
    public void addEdge(int source, int destination){
        adjacencyList[source].add(destination);
    }

    public void DFSUtil(int vertex, boolean visited[]){
        //Mark the current node as visited
        visited[vertex] = true;
        System.out.print(vertex + " ");
        int a =0;

        for ( int i=0; i< adjacencyList[vertex].getSize();i++){
            a = adjacencyList[vertex].get(i);
            if(!visited[a]){
                DFSUtil(a,visited);
            }
        }


    }

    public void DFS( int vertex){
        boolean already[] = new boolean[vertices];
        DFSUtil(vertex, already);
    }
    public static void main(String args[])
    {
        recursiveDFSGraph g = new recursiveDFSGraph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        System.out.println(
                "Following is Depth First Traversal: ");

        g.DFS(0);
    }


}
