package DynamicPrograming;

/**
 *
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 *
 */
public class MinCoinSum {

    static int coins[];

    public static void main(String[] args) {

        coins = new int[]{9, 6, 5};
        int sum = 11;
        System.out.println("Minimum count is " + minCoin(coins,sum));

    }

    public static int minCoin(int coins[],int sum){

        int minCoinDPSum[]=new int[sum+1];

        minCoinDPSum[0]=0;

        for(int i=1;i<=sum;i++){
            minCoinDPSum[i]=Integer.MAX_VALUE;
        }

        for(int i=1;i<=sum;i++){

            int minvalue=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){

                if(coins[j]<=i){

                    if(minCoinDPSum[i-coins[j]]==Integer.MAX_VALUE){
                        continue;
                    }
                    minvalue=Math.min(minvalue,minCoinDPSum[i-coins[j]]+1);
                }
            }
            minCoinDPSum[i]=minvalue;
        }
        return minCoinDPSum[sum];


    }

}
