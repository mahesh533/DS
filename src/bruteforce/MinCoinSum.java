package bruteforce;

/**
 *
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 *
 */

public class MinCoinSum {

    static int coins[];

    public static void main(String[] args) {

         coins=new int[]{9, 6, 5, 1};
        int sum=11;
        System.out.println("Minimum count is "+minCoin(sum,0));

    }

    public static int minCoin(int localsum,int count){

        if(localsum==0){
            return count;
        }else if (localsum < 0 ){
            return Integer.MAX_VALUE;
        }
        int MIN_STEPS=Integer.MAX_VALUE;
        for(int i=0; i<coins.length;i++){

            MIN_STEPS=Math.min(MIN_STEPS,minCoin(localsum-coins[i], count+1));
        }
        return MIN_STEPS;
    }


}
