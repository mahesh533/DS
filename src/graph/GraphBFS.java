package graph;

// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class GraphBFS
{
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    GraphBFS(int v)
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
    void BFS(int s)
    {
        Boolean visited[]=new Boolean[V];
        Arrays.fill(visited,false);

        Queue<Integer> q=new LinkedList<Integer>();

        q.add(s);
        visited[s]=true;

        while (!q.isEmpty()){
           int pNode= q.remove();
            System.out.println("Visited "+pNode);

            for (int cNode: adj[pNode]) {
                if(visited[cNode]==false){
                    visited[cNode]=true;
                    q.add(cNode);
                }
            }
        }


    }

    // Driver method to
    public static void main(String args[])
    {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(0);
    }
}
// This code is contributed by Aakash Hasija
