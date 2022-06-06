
import Graph.MyStack;

import java.util.Iterator;

public class StackDFSGraph {

    int V; //Number of Vertices
    MyLinkedList<Integer>[] adj; // adjacency lists

    //Constructor
    public StackDFSGraph(int V)
    {
        this.V = V;
        adj = new MyLinkedList[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new MyLinkedList<Integer>();

    }

    public void addEdge(int v, int neighbor) {

        adj[v].add(neighbor);

    }

    public void DFS(int s) {

        // Initially mark all vertices as not visited
        boolean visited[] = new boolean[V];

        // Create a stack for DFS
        MyStack<Integer> stack = new MyStack<>();

        // Push the current source node
        stack.push(s);

        while (stack.isEmpty() == false) {
            // Pop a vertex from stack and print it
            s = stack.peek();
            stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if (visited[s] == false) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            // Get all adjacent vertices of the popped vertex s
            // If a adjacent has not been visited, then push it
            // to the stack.


            for(int i =0; i<adj[s].getSize();i++){
                int visiting=adj[s].get(i);
                /* only insert nodes into queue if they have not been explored already */
                if(!visited[visiting]){
                    stack.push(visiting);
                }
            }


        }
    }

    public static void main(String[] args)
    {
        // Total 5 vertices in graph
        StackDFSGraph g = new StackDFSGraph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }
}

