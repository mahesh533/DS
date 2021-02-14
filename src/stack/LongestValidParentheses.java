package stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/solution/
 *
 *
 *
 */

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {

   /* @// TODO: 10/08/20  */
    public static void main(String[] args) {

        System.out.println( longestValidParentheses(")()())"));

    }

    public static int longestValidParentheses(String s) {

        Stack<Pair> stack=new Stack<Pair>();
        int longest=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

           if(c=='('){
               stack.push(new Pair(i,c));
           }else{
               if(!stack.isEmpty() && stack.peek().pChar == '('){
                  Pair p= stack.pop();
                   longest=Math.max(longest,i+1-p.pos);
               }else{
                   stack.push(new Pair(i,c));
               }
           }


        }
        return longest;

    }

    static class Pair{
        public int pos;
        public char pChar;

        public Pair(int pos, char pChar) {
            this.pos = pos;
            this.pChar = pChar;
        }
    }
}
