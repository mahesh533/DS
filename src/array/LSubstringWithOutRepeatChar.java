package array;

import java.util.HashMap;

public class LSubstringWithOutRepeatChar {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("tmmzuxt"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int length=s.length();
        int startIndex=0;
        int longest=0;
        HashMap<Character,Integer> loc=new HashMap<Character,Integer>();

        for(int i=0;i<length;i++){

            Character pre=s.charAt(i);
            if(loc.containsKey(pre) && startIndex <= loc.get(pre)){
                startIndex=loc.get(pre)+1;
                loc.put(pre,i);
            }else{
              loc.put(pre,i);
                if ( (i-startIndex+1) > longest) {
                    longest=(i-startIndex)+1;
                }
            }

        }

        return longest;
    }




}
