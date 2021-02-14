package misc;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
 */

public class LetterCombinationOfPhoneNumber {


    public static void main(String[] args) {

        for(String p:letterCombinations("23") ){
            System.out.println(p);
        }

    }

    public static List<String> letterCombinations(String digits) {



        List<String> finalList=new ArrayList<String>();

        if(digits==null || digits.equals(""))
            return finalList;

        String lookUP[]={"0","1","ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        Queue<String> q=new LinkedList<String>();


        q.add("");
        int length=1;
        for (char digit: digits.toCharArray()) {

           String possible=lookUP[digit-'0'];

            while(q.peek().length()<length){
                String temp=q.poll();

            for(char pre:possible.toCharArray()){
                    q.offer(temp+pre);
                }
            }
            length++;
        }


        return (List<String>)q;

    }
}
