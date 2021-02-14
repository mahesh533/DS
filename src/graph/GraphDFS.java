package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// This class represents a directed graph using adjacency list
// representation
class GraphDFS
{
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    GraphDFS(int v)
    {
        this.V=v;
        adj=new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<Integer>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void DFS(int s)
    {
        Boolean visited[]=new Boolean[V];
        Arrays.fill(visited,false);

        Stack<Integer> stack= new Stack<Integer>();

        stack.add(s);
        visited[s]=true;

        while (!stack.isEmpty()){
            int pNode= stack.pop();
            System.out.println("Visited "+pNode);

            for (int cNode: adj[pNode]) {
                if(visited[cNode]==false){
                    visited[cNode]=true;
                    stack.push(cNode);
                }
            }
        }


    }

    // Driver method to
    public static void main(String args[])
    {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(0);
    }
}
// This code is contributed by Aakash Hasija

