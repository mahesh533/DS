package string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestPalindromeSubString {

    public static void main(String[] args) {


        String str="adddjlkcbabcklj";
        System.out.println("max is "+getLongestPalindrome( str));



    }

    public static int getLongestPalindrome(String str){
        int length=str.length();

        int dp[][]=new int[length][length];
        int max=0;

        IntStream.range(0,length).forEach(i-> Arrays.fill(dp[i],0));
        IntStream.range(0,length).forEach(i->dp[i][i]=1);
        IntStream.range(0,length-1).filter(i->str.charAt(i)==str.charAt(i+1)).forEach(i->dp[i][i+1]=1);
        IntStream.range(0,length).forEach(i-> System.out.println(Arrays.toString(dp[i])));

        for(int i=3;i<length;i++){
            for(int startIndex=0;startIndex<length-i+1;startIndex++){
                //System.out.println("i "+i+" StartIndex "+startIndex+" endIndex "+endIndex);
                int endIndex=i+startIndex-1;
                System.out.println("i "+i+" StartIndex "+startIndex+" endIndex "+endIndex);
                if(str.charAt(startIndex)==str.charAt(endIndex) && dp[startIndex+1][endIndex-1]==1 ){
                    dp[startIndex][endIndex]=1;
                    max=Math.max(max,i);
                }

            }
        }
        return max;

    }
}
