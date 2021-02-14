package bruteforce;

public class CoinChangeNumberofWays {

    static int count=0;

    public static void main(String[] args) {

        int sum=3;
        int[] coins={1,2,3,8};
        System.out.println( bruteForce(coins,sum,coins.length));
        System.out.println(count);

    }

    public static int bruteForce(int []coins,int sum , int index){


        if(index==0){
                return 0;
        }
        if(sum <0 ){
            return 0;
        }else if(sum ==0 ){
            return 1;
        }
        if(coins[index-1] > sum)
        {
            return bruteForce(coins, index-1, sum);
        }

       return bruteForce(coins, sum-coins[index-1],index ) + bruteForce(coins, index-1, sum);

    }
}
