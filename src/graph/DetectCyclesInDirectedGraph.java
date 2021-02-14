package graph;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class DetectCyclesInDirectedGraph {

    static class Graph{
        int vertex;
        List<List<Integer>> adj=new ArrayList<List<Integer>>();

        public Graph(int vertex) {
            this.vertex = vertex;
            IntStream.range(0,vertex).forEach(i->
                    adj.add(new ArrayList<Integer>())
            );
        }

        public void print(){

            IntStream.range(0,vertex).forEach(
                    i-> {
                        System.out.println(i+" -- > "+adj.get(i));
                    }
            );
        }

        public void addEdge(int from, int to) {
            adj.get(from).add(to);
        }
    }
    static Graph g;
    public static void main(String[] args) {

        g=new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
       // g.addEdge(3, 3);
        g.print();
        System.out.println(detectCyclesInGraph(g));

    }

    public static boolean detectCyclesInGraph(Graph g){

        int vCount=g.vertex;
        boolean visited[]=new boolean[vCount];
        Arrays.fill(visited,false);
        Set<Integer> stack=new HashSet<Integer>();

        for(int i=0;i<vCount;i++){


                if(hasCycle(g,visited,i,stack))
                    return true ;

        }
        return false;

    }
    public static boolean hasCycle(Graph g,boolean visited[], int pVertex, Set<Integer> stack){

        if(stack.contains(pVertex)){
            return true;
        }
        if(visited[pVertex]==true){
            return false;
        }
        visited[pVertex]=true;
        stack.add(pVertex);

        for(Integer i: g.adj.get(pVertex)){
            if(hasCycle(g,visited,i,stack))
                    return true;
        }
        stack.remove(pVertex);
        return false;
    }
}
