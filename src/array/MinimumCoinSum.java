package array;

import java.util.Stack;

public class MinimumCoinSum {

    static int minCount=Integer.MAX_VALUE;
    static Stack<Integer> coinStack=new Stack<Integer>();

    public static void main(String[] args) {

        int X = 21, arr[] = {2, 3, 4, 5};
         Stack<Integer> tempStack=new Stack<Integer>();
        coinSum( X, arr,  0,tempStack);
        System.out.println(minCount);
        coinStack.stream().forEach(System.out::println);
    }

    public static void coinSum(int sum, int []coins, int size,Stack<Integer> pStack){

        if(sum == 0){
            if(minCount > size){
                minCount=size;
                coinStack=(Stack)pStack.clone();
            }

        }

        if(sum < 0){
            return;
        }

        for(Integer i : coins){
            pStack.add(i);
            coinSum( sum-i, coins,  size+1,pStack);
            pStack.remove(i);
        }
    }
}
