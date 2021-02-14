package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStocksMaxProfit {

    public static void main(String[] args) {

        int price[] = { 100, 180, 260, 310, 40, 535, 695 };

        maxProfit(price);

    }

    static int maxProfit(int[] price){

        int index=0;
        List<List<Integer>> pair=new ArrayList<List<Integer>>();

        while (index<price.length) {

            //find local minima
            int nextIndex = index;
            int localmin = 0;
            int localmax = 0;

            for (int i = index; i < price.length - 2; i++) {
                if (price[i] < price[i + 1]) {
                    localmin = price[i];
                    nextIndex = Math.max(i, nextIndex);
                    break;
                }else{
                    localmin = price[i];
                    nextIndex = Math.max(i, nextIndex);
                }
            }
            //find local maxima
            for (int i = nextIndex+1; i < price.length - 1; i++) {
                if (price[i+1] > price[i]) {
                    localmax = price[i+1];
                    nextIndex = Math.max(i, nextIndex+1);
                    break;
                }else{
                    localmax = price[i];
                    nextIndex = Math.max(i, nextIndex);
                }
            }
            List<Integer> l = new ArrayList<Integer>();
            // add the pair
            l.add(localmin);
            l.add(localmax);

            System.out.println("next index "+nextIndex+" localminima "+localmin+"local maxima "+localmax);
            pair.add(l);
            index=nextIndex+1;
        }


            // TODO: 06/01/21  return correct vale
            return 0;
        }







}
