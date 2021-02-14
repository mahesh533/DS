package array;

import java.util.Arrays;

public class BuyAndSellStockOnce {
    static int min=Integer.MAX_VALUE;
    static int maxProfit=Integer.MIN_VALUE;

    public static void main(String[] args) {

        int arr[]={1, 2, 90, 10, 110};


        System.out.println(maxProfit(arr));

    }

    public static int maxProfit(int []array){

        int length=array.length;


        for (int i : array){
            System.out.println(i);
        }

        Arrays.stream(array).forEach(
                (i)->{

                    min=Math.min(i,min);
                    maxProfit=Math.max(i-min,maxProfit);

                }

        );
        return maxProfit;

    }
}
