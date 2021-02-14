package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */

public class OpenCloseParentheses {

    public static void main(String[] args) {

                List<String> list=generateParenthesis(2);
        for (String s:
             list) {
            System.out.println(s);
        }

    }


   public static List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public static void backtrack(List<String> ans, String cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }

            if (open < max)
                backtrack(ans, cur+"(", open+1, close, max);
            if (close < open)
                backtrack(ans, cur+")", open, close+1, max);
        }
    }

