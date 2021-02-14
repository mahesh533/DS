package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQueueMaxHeap {

    static class Pair{
        Integer start;
        Integer end;

        public Pair(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

   static PriorityQueue<Pair> pQ=new PriorityQueue<Pair>((a,b)->b.start.compareTo(a.start));

    public static void main(String[] args) {
        Pair p1=new Pair(10,20);
        Pair p2=new Pair(15,30);
        Pair p3=new Pair(25,30);

    }
}
