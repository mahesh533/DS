package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class CourseScheduler {

    static class Graph{

        Integer v;
        List<List<Integer>> adj =new ArrayList<List<Integer>>();

        public Graph(int v){
            this.v=v;
            IntStream.range(0,v).forEach((i)->
                    adj.add(new ArrayList<Integer>())
            );
        }

        public void addEdge(int from,int to){

            adj.get(from).add(to);
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "v=" + v +
                    ", adj=" + adj +
                    '}';
        }
    }
    public static void topoUtil(Graph g, int vertex,Stack<Integer> stack, boolean[] visited){

       visited[vertex]=true;

       List<Integer> adj=g.adj.get(vertex);
       for(Integer i:adj){

           if(visited[i]!=true){
               topoUtil(g,i,stack,visited);
           }
       }
       stack.add(vertex);

    }

    public static void topoSort(Graph g){

        int v=g.v;
        boolean visited[]=new boolean[v];
        Stack<Integer> stack=new Stack<Integer>();
        Arrays.fill(visited,false);
        //Arrays.fill(stack,false);

        for(int i=0;i<v;i++){
            if(visited[i]==false)
            topoUtil(g,i,stack,visited);
        }
        stack.stream().forEach(System.out::println);

    }
   static Graph g=new Graph(6);

    public static void main(String[] args) {

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        int count=0;

        IntStream.range(0,g.v).forEach(
                i->{
                    System.out.println(i+" - > "+g.adj.get(i));

                }
        );

        topoSort(g);
    }

}
