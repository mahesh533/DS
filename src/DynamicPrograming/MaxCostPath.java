package DynamicPrograming;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */

public class MaxCostPath {

    public static void main(String[] args) {

        int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };

        System.out.println("Max cost path is "+maxCostPath( cost));

    }

    public static int maxCostPath(int costs[][]){

        int dp[][]=new int[costs.length+1][costs[0].length+1];

        for(int i=0;i<=costs.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=costs[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=costs[0].length;i++){


            for(int j=1;j<=costs.length;j++){

                dp[i][j]=costs[i-1][j-1]+Math.min(dp[i-1][j],dp[i][j-1]);

            }
        }
        return dp[costs.length][costs[0].length];
    }
}
